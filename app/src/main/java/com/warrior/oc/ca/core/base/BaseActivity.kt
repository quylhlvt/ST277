package com.warrior.oc.ca.core.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.warrior.oc.ca.AppSession
import com.warrior.oc.ca.R
import com.warrior.oc.ca.core.extention.InternetExtension
import com.warrior.oc.ca.core.extention.gone
import com.warrior.oc.ca.core.extention.hideNavigation
import com.warrior.oc.ca.core.extention.visible
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import com.warrior.oc.ca.databinding.DialogbaseBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(
    private val bindingInflater: (LayoutInflater) -> VB,
    private val viewModelClass: Class<VM>
) : AppCompatActivity() {
    protected lateinit var binding: VB
        private set
    protected val viewModel: VM by lazy { ViewModelProvider(this)[viewModelClass] }
    @Inject lateinit var appSession: AppSession
    @Inject lateinit var sharedPreferences: SharedPreferencesManager
    protected var toast: Toast? = null
    private var navigationPending = false

    override fun attachBaseContext(newBase: Context) {
        val preferences = newBase.getSharedPreferences("DEFAULT", MODE_PRIVATE)
        val language = preferences.getString("language_key", "en").orEmpty().ifEmpty { "en" }
        val config = Configuration(newBase.resources.configuration)
        config.setLocale(Locale(language))
        super.attachBaseContext(newBase.createConfigurationContext(config))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)
        hideNavigation(true)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!handleBackPressed()) finish()
            }
        })
        setupPreViews()
        initView()
        if (isFinishing) return
        initText()
        viewListener()
        bindViewModel()
        observeData()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                appSession.networkOnline.filter { it }.collect {
                    if (appSession.templates.value.none { it.id.startsWith("online_") }) {
                        appSession.fetchOnlineTemplates()
                    }
                }
            }
        }
    }

    /** Each screen is a real Activity. Guard repeated taps until it resumes. */
    fun openActivity(
        destination: Class<out Activity>,
        extras: Bundle? = null,
        finishCurrent: Boolean = false,
        clearTop: Boolean = false,
        clearTask: Boolean = false,
        recreateTarget: Boolean = false
    ) {
        if (isFinishing || isDestroyed || navigationPending ||
            !lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) return
        navigationPending = true
        val next = Intent(this, destination).apply {
            extras?.let { putExtras(it) }
            if (clearTop) {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                if (!recreateTarget) addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
            if (clearTask) addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(next)
        if (finishCurrent) finish()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    override fun onResume() {
        super.onResume()
        navigationPending = false
        if (hasWindowFocus()) hideNavigation(true)
        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, javaClass.simpleName.removeSuffix("Activity"))
            putString(FirebaseAnalytics.Param.SCREEN_CLASS, javaClass.simpleName)
        })
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideNavigation(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onDestroy() {
        toast?.cancel()
        globalLoadingDialog?.dismiss()
        globalLoadingDialog = null
        globalConfirmDialog?.dismiss()
        globalConfirmDialog = null
        super.onDestroy()
    }

    protected open fun handleBackPressed(): Boolean = false
    open fun setupPreViews() {}
    open fun initView() {}
    open fun initText() {}
    open fun observeData() {}
    abstract fun viewListener()
    abstract fun bindViewModel()

    private var globalLoadingDialog: Dialog? = null
    private var globalConfirmDialog: Dialog? = null

    private fun canShowWindow(): Boolean =
        !isFinishing && !isDestroyed

    private fun showGlobalLoading() {
        if (globalLoadingDialog?.isShowing == true) return
        runOnUiThread {
            if (!canShowWindow()) return@runOnUiThread
            if (globalLoadingDialog == null) {
                globalLoadingDialog = buildDialog(
                    message = getString(R.string.loading),
                    showButtons = false,
                    cancelable = false
                )
            }
            runCatching { globalLoadingDialog?.show() }
                .onFailure { globalLoadingDialog = null }
            hideNavigation(true)
        }
    }
    private fun showGlobalOkDialog(message: String, title: String?, onOk: (() -> Unit)?) {
        runOnUiThread {
            if (!canShowWindow()) return@runOnUiThread
            globalConfirmDialog?.dismiss()
            globalConfirmDialog = buildDialog(
                message = message,
                title = title,
                showButtons = true,
                cancelable = true,
                onOk = {
                    globalConfirmDialog?.dismiss()
                    globalConfirmDialog = null
                    onOk?.invoke()
                }
            )
            runCatching { globalConfirmDialog?.show() }
                .onFailure { globalConfirmDialog = null }
            hideNavigation(true)
        }
    }
    private fun hideGlobalLoading() {
        Log.d("LOADING", "hideGlobalLoading")

        runOnUiThread {
            globalLoadingDialog?.dismiss()
            globalLoadingDialog = null
            if (hasWindowFocus()) hideNavigation(true)
        }
    }

    private fun hideGlobalDialog() {
        runOnUiThread {
            if (!canShowWindow()) return@runOnUiThread
            globalConfirmDialog?.dismiss()
            globalConfirmDialog = null
            if (hasWindowFocus()) hideNavigation(true)
        }
    }

    private fun showGlobalConfirmDialog(
        message: String,
        title: String?,
        onYes: () -> Unit,
        onNo: (() -> Unit)?,
        yesText: String?,
        noText: String?
    ) {
        runOnUiThread {
            if (!canShowWindow()) return@runOnUiThread
            globalConfirmDialog?.dismiss()
            globalConfirmDialog = buildDialog(
                message = message,
                title = title,
                showButtons = true,
                cancelable = true,
                yesText = yesText,
                noText = noText,
                onYes = {
                    globalConfirmDialog?.dismiss()
                    globalConfirmDialog = null
                    onYes()
                },
                onNo = {
                    globalConfirmDialog?.dismiss()
                    globalConfirmDialog = null
                    onNo?.invoke()
                }
            )
            globalConfirmDialog?.show()
            hideNavigation(true)
        }
    }

    // Builder dùng chung
    private fun buildDialog(
        message: String,
        title: String? = null,
        showButtons: Boolean = false,
        cancelable: Boolean = false,
        onYes: (() -> Unit)? = null,
        onNo: (() -> Unit)? = null,
        onOk: (() -> Unit)? = null,
        yesText: String? = null,
        noText: String? = null
    ): Dialog {
        return Dialog(this, R.style.BaseDialog).apply {
            val binding = DialogbaseBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.txtYes.isSelected = true
            binding.tvTitle.isSelected = true
            binding.txtNo.isSelected = true
            title?.let { binding.tvTitle.text = it }
            binding.txtContent.text = message
            yesText?.let { binding.txtYes.text = it }
            noText?.let { binding.txtNo.text = it }

            if (showButtons) {
                binding.txtContent.visible()
                binding.progressBar.gone()
                binding.txtPlease.gone()

                if (onOk != null) {
                    // ← chế độ OK only
                    binding.btnYes.gone()
                    binding.btnNo.gone()
                    binding.btnOk.visible()
                    binding.btnOk.setOnClickListener { onOk.invoke() }
                } else {
                    // ← chế độ Yes/No
                    binding.btnYes.visible()
                    binding.btnNo.visible()
                    binding.btnOk.gone()
                    binding.btnYes.setOnClickListener { onYes?.invoke() }
                    binding.btnNo.setOnClickListener { onNo?.invoke() }
                }
            } else {
                binding.btnYes.gone()
                binding.btnNo.gone()
                binding.btnOk.gone()
                binding.txtContent.gone()
                Glide.with(binding.progressBar)
                    .asGif()
                    .load(R.drawable.gif_loading)
                    .into(binding.progressBar)
                binding.progressBar.visible()
                binding.txtPlease.visible()
            }

            setCancelable(cancelable)
            window?.apply {
                setBackgroundDrawableResource(R.color.transparent)
                setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT
                )
                setGravity(Gravity.CENTER)
            }
        }
    }

    fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    fun showToast(content: Any) {
        if (toast != null) {
            toast?.cancel()
        }
        val contentString = when (content) {
            is String -> content
            is Int -> getString(content)
            else -> {
                ""
            }
        }
        toast = Toast.makeText(this, contentString, Toast.LENGTH_SHORT)
        toast?.show()
    }

    fun hideLoading() {
        hideGlobalLoading()
    }

    fun showLoadingSafe() {
        if (isFinishing || isDestroyed) return
        showGlobalLoading()
    }

    fun hideLoadingSafe() {
        if (isFinishing || isDestroyed) return
        hideGlobalLoading()
    }

    fun hideGlobalDialogSafe() {
        if (isFinishing || isDestroyed) return
        hideGlobalDialog()
    }

// ========== Confirm Dialog ==========

    fun showConfirmDialog(
        message: String,
        title: String? = null,
        onYes: () -> Unit,
        onNo: (() -> Unit)? = null,
        yesText: String? = null,
        noText: String? = null
    ) {
        if (isFinishing || isDestroyed) return
        showGlobalConfirmDialog(
            message = message,
            title = title,
            onYes = onYes,
            onNo = onNo,
            yesText = yesText,
            noText = noText
        )
    }
    fun showNoInternetDialog(onOk: (() -> Unit)? = null) {
        showOkDialog(
            title = getString(R.string.no_internet),
            message = getString(R.string.please_connect_to_the_internet_to_download_more_data),
            onOk = onOk
        )
    }
    fun showLoadingDataDialog(onOk: (() -> Unit)? = null) {
        showOkDialog(
            title = getString(R.string.internet),
            message = getString(R.string.please_wait_a_few_seconds_for_data_to_load),
            onOk = onOk
        )
    }
    fun showUnstableNetworkDialog(onOk: (() -> Unit)? = null) {
        showOkDialog(
            title = getString(R.string.internet),
            message = getString(R.string.unstable_connection_please_check_your_network_connection),
            onOk = onOk
        )
    }

    fun checkNetworkAndShowDialog() {
        val context = this
        when {
            !InternetExtension.isInternetAvailable(context) -> showNoInternetDialog()
            !InternetExtension.isNetworkConnected(context) -> showUnstableNetworkDialog()
            else -> {}
        }
    }
    fun showOkDialog(
        message: String,
        title: String? = null,
        onOk: (() -> Unit)? = null
    ) {
        if (isFinishing || isDestroyed) return
        showGlobalOkDialog(
            message = message,
            title = title,
            onOk = onOk
        )
    }
}
