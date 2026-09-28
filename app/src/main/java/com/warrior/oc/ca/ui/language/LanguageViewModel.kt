package com.warrior.oc.ca.ui.language

import androidx.lifecycle.ViewModel
import com.warrior.oc.ca.data.model.language.LanguageModel
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import com.warrior.oc.ca.utils.DataLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor() : ViewModel() {
    private val _languageList = MutableStateFlow<List<LanguageModel>>(emptyList())
    val languageList: StateFlow<List<LanguageModel>> = _languageList.asStateFlow()

    private val _codeLang = MutableStateFlow("")
    val codeLang: StateFlow<String> = _codeLang.asStateFlow()

    private val _isFirstLanguage = MutableStateFlow(false)
    val isFirstLanguage: StateFlow<Boolean> = _isFirstLanguage.asStateFlow()

    fun initialize() {
        val isFirst = !SharedPreferencesManager.isLanuageScreen()
        _isFirstLanguage.value = isFirst
        loadLanguages(SharedPreferencesManager.isLanguageKey())
    }

    fun loadLanguages(currentLang: String) {
        val list = DataLocal.getLanguageList().map { it.copy(activate = false) }.toMutableList()
        val index = list.indexOfFirst { it.code == currentLang }
        if (index != -1) {
            val selected = list.removeAt(index)
            list.add(0, selected.copy(activate = !isFirstLanguage.value))
        }
        _codeLang.value = currentLang
        _languageList.value = list
    }

    fun selectLanguage(code: String) {
        _codeLang.value = code
        val updatedList = _languageList.value.map {
            it.copy(activate = it.code == code)
        }
        _languageList.value = updatedList
    }

    fun hasCompletedLanguageSelection(): Boolean = SharedPreferencesManager.isLanuageScreen()

    /** Persists a valid choice and reports which destination the screen should open. */
    fun completeSelection(): LanguageCompletion? {
        val code = _codeLang.value
        if (code.isBlank()) return null

        val isFirstLanguage = _isFirstLanguage.value
        SharedPreferencesManager.setLanguageKey(code)
        if (isFirstLanguage) SharedPreferencesManager.setLanuageScreen(true)
        return LanguageCompletion(code, isFirstLanguage)
    }
}

data class LanguageCompletion(val code: String, val isFirstLanguage: Boolean)
