package com.anime.oc.characters.avatar.ui.language;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/language/LanguageViewModel;", "Landroidx/lifecycle/ViewModel;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "_codeLang", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isFirstLanguage", "", "_languageList", "", "Lcom/anime/oc/characters/avatar/data/model/language/LanguageModel;", "codeLang", "Lkotlinx/coroutines/flow/StateFlow;", "getCodeLang", "()Lkotlinx/coroutines/flow/StateFlow;", "isFirstLanguage", "languageList", "getLanguageList", "loadLanguages", "", "currentLang", "selectLanguage", "code", "setFirstLanguage", "isFirst", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LanguageViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.language.LanguageModel>> _languageList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.language.LanguageModel>> languageList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _codeLang = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> codeLang = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFirstLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFirstLanguage = null;
    
    @javax.inject.Inject()
    public LanguageViewModel(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.language.LanguageModel>> getLanguageList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCodeLang() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFirstLanguage() {
        return null;
    }
    
    public final void loadLanguages(@org.jetbrains.annotations.NotNull()
    java.lang.String currentLang) {
    }
    
    public final void selectLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    public final void setFirstLanguage(boolean isFirst) {
    }
}