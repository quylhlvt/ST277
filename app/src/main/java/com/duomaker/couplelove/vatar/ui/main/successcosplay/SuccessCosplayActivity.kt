package com.duomaker.couplelove.vatar.ui.main.successcosplay

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.checkPermissions
import com.duomaker.couplelove.vatar.core.extention.goToSettings
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.setImageActionBar
import com.duomaker.couplelove.vatar.databinding.ActivitySuccessCosplayBinding
import com.duomaker.couplelove.vatar.ui.main.home.HomeActivity
import com.duomaker.couplelove.vatar.ui.main.show.ShowActivity
import com.duomaker.couplelove.vatar.ui.onboarding.permission.PermissionViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileOutputStream

@AndroidEntryPoint
class SuccessCosplayActivity : BaseActivity<ActivitySuccessCosplayBinding, SuccessCosplayViewModel>(
    ActivitySuccessCosplayBinding::inflate,
    SuccessCosplayViewModel::class.java
) {
    private val permissionViewModel: PermissionViewModel by viewModels()
    private var resultImagePath: String = ""

    private val downloadPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions.entries.all { it.value }) {
                permissionViewModel.onStorageGranted()
                performDownload()
            } else {
                permissionViewModel.onStorageDenied()
                showToast(getString(R.string.download_failed_please_try_again_later))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBackPressHandler()
    }

    private fun setupBackPressHandler() {
        this@SuccessCosplayActivity.onBackPressedDispatcher.addCallback(
            this@SuccessCosplayActivity,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                }
            }
        )
    }
    private fun replayShow() {
        val replayIntent = Intent(
            this@SuccessCosplayActivity,
            ShowActivity::class.java
        ).apply {
            // Lấy lại template + selections đã được truyền từ Show
            intent.extras?.let { putExtras(it) }
        }

        startActivity(replayIntent)
        finish()
    }
    override fun initView() {
        binding.apply {
            setImageActionBar(actionBar.btnActionBarLeft, R.drawable.back_app1)
            setImageActionBar(actionBar.btnActionBarRight, R.drawable.ic_home)
            txtDownload.isSelected = true

            val resultBitmap = appSession.userResultBitmap
                ?.takeUnless { it.isRecycled }
            resultBitmap?.let {
                imvImage.setImageBitmap(it)
                resultImagePath = persistResultBitmap(it)
            }

            updateOccupancy(appSession.cosplayPercent)
        }
    }

    private fun updateOccupancy(percent: Int) {
        val safePercent = percent.coerceIn(0, 100)
        val occupiedCount = when (safePercent) {
            0 -> 0
            in 1..33 -> 1
            in 34..66 -> 2
            else -> 3
        }
        val indicators = listOf(binding.occupy1, binding.occupy2, binding.occupy3)

        indicators.forEachIndexed { index, indicator ->
            indicator.setImageResource(
                if (index < occupiedCount) R.drawable.img_occupy
                else R.drawable.img_unoccupy
            )
        }
    }

    override fun viewListener() {

        binding.apply {
            actionBar.btnActionBarLeft.onClick {
                replayShow()
            }
            actionBar.btnActionBarRight.onClick {
                openActivity(HomeActivity::class.java, clearTop = true)
            }
            btnDownload.onClick { downloadImage() }
        }
    }

    private fun persistResultBitmap(bitmap: Bitmap): String {
        val file = File(filesDir, "cosplay_result.png")
        runCatching {
            FileOutputStream(file).use { bitmap.compress(Bitmap.CompressFormat.PNG, 100, it) }
        }.onFailure { return "" }
        return file.absolutePath
    }

    private fun downloadImage() {
        if (resultImagePath.isBlank()) {
            showToast(getString(R.string.download_failed_please_try_again_later))
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            performDownload()
            return
        }
        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
        when {
            checkPermissions(arrayOf(permission)) -> performDownload()
            permissionViewModel.shouldGoToSettings(isStorage = true) -> goToSettings()
            else -> downloadPermissionLauncher.launch(arrayOf(permission))
        }
    }

    private fun performDownload() {
        viewModel.downloadFile(this@SuccessCosplayActivity, resultImagePath) { success ->
            showToast(
                if (success) getString(R.string.download_success, getString(R.string.app_name))
                else getString(R.string.download_failed_please_try_again_later)
            )
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@SuccessCosplayActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun observeData() = Unit

    override fun bindViewModel() = Unit
}
