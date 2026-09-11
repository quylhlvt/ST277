package com.anime.oc.characters.avatar.ui.main.successcosplay

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import com.anime.oc.characters.avatar.R
import com.anime.oc.characters.avatar.core.base.BaseActivity
import com.anime.oc.characters.avatar.core.extention.InternetExtension.isInternetAvailable
import com.anime.oc.characters.avatar.core.extention.onClick
import com.anime.oc.characters.avatar.core.extention.select
import com.anime.oc.characters.avatar.core.extention.setImageActionBar
import com.anime.oc.characters.avatar.core.extention.setTextActionBar
import com.anime.oc.characters.avatar.databinding.ActivitySuccessCosplayBinding
import com.anime.oc.characters.avatar.ui.main.cosplay.CosplayActivity
import com.anime.oc.characters.avatar.ui.main.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class SuccessCosplayActivity : BaseActivity<ActivitySuccessCosplayBinding, SuccessCosplayViewModel>( ActivitySuccessCosplayBinding::inflate, SuccessCosplayViewModel::class.java) {
    private var starAnimator: ValueAnimator? = null
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

    override fun initView() {
        binding.apply {

            txtShow.isSelected = true
            setupActionBar()
            val userBitmap = appSession.userResultBitmap
            if (userBitmap != null && !userBitmap.isRecycled) {
                imvImage2.setImageBitmap(userBitmap)
            }

            // imvImage3 = ảnh cosplay gốc
            val cosplayBitmap = appSession.cosplayBitmap
            if (cosplayBitmap != null && !cosplayBitmap.isRecycled) {
                imvImage3.setImageBitmap(cosplayBitmap)
            }

            val percent = appSession.cosplayPercent
            val starCount = when (percent) {
                0 -> 0
                in 1..20 -> 1
                in 21..40 -> 2
                in 41..70 -> 3
                in 71..98 -> 4
                in 99..100 -> 5
                else -> 0
            }
            binding.ll1.rating = starCount.toFloat()
            updateProgressBar(percent)
        }
    }
    private fun updateProgressBar(percent: Int) {
        val safePercent = percent.coerceIn(0, 100)
        val targetBias = safePercent / 100f

        binding.layoutProgress.post {
            if (isFinishing || isDestroyed) return@post

            val currentBias =
                (binding.imgStar.layoutParams as ConstraintLayout.LayoutParams)
                    .horizontalBias
                    .coerceIn(0f, 1f)

            starAnimator?.cancel()
            starAnimator = ValueAnimator.ofFloat(currentBias, targetBias).apply {
                duration = 400L
                interpolator = DecelerateInterpolator()
                addUpdateListener { animator ->
                    val animatedBias = animator.animatedValue as Float

                    binding.imgStar.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        horizontalBias = animatedBias
                    }
                    binding.tvMatchPercent.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                        horizontalBias = animatedBias
                    }
                    val animatedPercent = (animatedBias * 100)
                        .roundToInt()
                        .coerceIn(0, safePercent)
                    binding.tvMatchPercent.text = "$animatedPercent/100"
                }
                start()
            }
        }
    }

    override fun onDestroy() {
        starAnimator?.cancel()
        starAnimator = null
        super.onDestroy()
    }
    private fun ActivitySuccessCosplayBinding.setupActionBar() {
        actionBar.apply {
            tvCenter.select()
            setImageActionBar(
                btnActionBarRight,
                R.drawable.ic_home
            )
//            setTextActionBar(tvCenter, getString(R.string.successfully))
        }
    }

    override fun viewListener() {
        binding.apply {
            setupActionBarListeners()
            setupNavigationListeners()
        }
    }

    private fun ActivitySuccessCosplayBinding.setupActionBarListeners() {
        actionBar.btnActionBarRight.onClick {
                openActivity(HomeActivity::class.java, clearTop = true)

        }
    }

    private fun ActivitySuccessCosplayBinding.setupNavigationListeners() {
        btnTryAgain.onClick {
            if (!isInternetAvailable(this@SuccessCosplayActivity)) {
                showUnstableNetworkDialog(); return@onClick
            }
            openActivity(CosplayActivity::class.java, Bundle().apply {
                putBoolean(CosplayActivity.EXTRA_START_CHALLENGE, true)
            }, clearTop = true)

        }
    }

    override fun observeData() {}

    override fun bindViewModel() {}
}
