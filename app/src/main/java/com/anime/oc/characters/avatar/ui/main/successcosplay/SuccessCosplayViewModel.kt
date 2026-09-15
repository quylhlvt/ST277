package com.anime.oc.characters.avatar.ui.main.successcosplay

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.oc.characters.avatar.core.helper.DownloadHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SuccessCosplayViewModel   @Inject constructor() : ViewModel() {
    fun downloadFile(context: Context, path: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            onResult(DownloadHelper.downloadToGallery(context, path))
        }
    }
}
