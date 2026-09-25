package com.warrior.oc.ca.ui.main.camera

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.warrior.oc.ca.R
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.databinding.ActivityCameraBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraActivity : BaseActivity<ActivityCameraBinding, CameraViewModel>(
    ActivityCameraBinding::inflate,
    CameraViewModel::class.java
) {
    private var cameraProvider: ProcessCameraProvider? = null

    override fun initView() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            finish()
            return
        }
        startCameraPreview()
    }

    override fun viewListener() {
        binding.btnBack.onClick { finish() }
    }

    private fun startCameraPreview() {
        val providerFuture = ProcessCameraProvider.getInstance(this)
        providerFuture.addListener({
            if (isFinishing || isDestroyed) return@addListener

            runCatching {
                val provider = providerFuture.get()
                val preview = Preview.Builder().build().also {
                    it.surfaceProvider = binding.previewView.surfaceProvider
                }
                val selector = when {
                    provider.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA) ->
                        CameraSelector.DEFAULT_BACK_CAMERA
                    provider.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA) ->
                        CameraSelector.DEFAULT_FRONT_CAMERA
                    else -> error("No camera is available")
                }

                provider.unbindAll()
                provider.bindToLifecycle(this, selector, preview)
                cameraProvider = provider
            }.onFailure { error ->
                Log.e("CameraActivity", "Unable to start camera preview", error)
                showToast(R.string.camera_unavailable)
                finish()
            }
        }, ContextCompat.getMainExecutor(this))
    }

    override fun onDestroy() {
        cameraProvider?.unbindAll()
        cameraProvider = null
        super.onDestroy()
    }

    override fun observeData() = Unit

    override fun bindViewModel() = Unit
}
