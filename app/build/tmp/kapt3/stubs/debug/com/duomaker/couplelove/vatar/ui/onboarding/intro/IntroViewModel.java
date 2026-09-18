package com.duomaker.couplelove.vatar.ui.onboarding.intro;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/onboarding/intro/IntroViewModel;", "Landroidx/lifecycle/ViewModel;", "sharedPreferences", "Lcom/duomaker/couplelove/vatar/core/helper/SharedPreferencesManager;", "(Lcom/duomaker/couplelove/vatar/core/helper/SharedPreferencesManager;)V", "_singleEvent", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/duomaker/couplelove/vatar/ui/onboarding/intro/IntroSingleEvent;", "_uiState", "Lcom/duomaker/couplelove/vatar/ui/onboarding/intro/IntroUiState;", "singleEvent", "Lkotlinx/coroutines/flow/Flow;", "getSingleEvent", "()Lkotlinx/coroutines/flow/Flow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getData", "", "getPage", "currentPage", "", "totalPages", "navigateToNextScreen", "nextPage", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class IntroViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.duomaker.couplelove.vatar.ui.onboarding.intro.IntroUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.duomaker.couplelove.vatar.ui.onboarding.intro.IntroSingleEvent> _singleEvent = null;
    
    @javax.inject.Inject()
    public IntroViewModel(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager sharedPreferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.duomaker.couplelove.vatar.ui.onboarding.intro.IntroUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.duomaker.couplelove.vatar.ui.onboarding.intro.IntroSingleEvent> getSingleEvent() {
        return null;
    }
    
    private final void getData() {
    }
    
    private final void navigateToNextScreen() {
    }
    
    public final void getPage(int currentPage, int totalPages) {
    }
    
    public final void nextPage(int currentPage, int totalPages) {
    }
}