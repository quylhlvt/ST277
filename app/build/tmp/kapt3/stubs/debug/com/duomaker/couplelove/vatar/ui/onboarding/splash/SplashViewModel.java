package com.duomaker.couplelove.vatar.ui.onboarding.splash;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002JF\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\bJ\u0006\u0010\u0019\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/onboarding/splash/SplashViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_dataReadySignal", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_navigateSignal", "dataReadySignal", "Lkotlinx/coroutines/flow/StateFlow;", "getDataReadySignal", "()Lkotlinx/coroutines/flow/StateFlow;", "initTime", "", "isTimerRunning", "navigateSignal", "getNavigateSignal", "startSplashTimer", "", "hasNetwork", "hasOnlineTemplates", "templatesFlow", "", "Lcom/duomaker/couplelove/vatar/data/model/custom/CustomModel;", "imagesReadyFlow", "localDataReadyFlow", "triggerNavigate", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SplashViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _dataReadySignal = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> dataReadySignal = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _navigateSignal = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> navigateSignal = null;
    private boolean isTimerRunning = false;
    private final long initTime = 0L;
    
    @javax.inject.Inject()
    public SplashViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getDataReadySignal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNavigateSignal() {
        return null;
    }
    
    public final void triggerNavigate() {
    }
    
    public final void startSplashTimer(boolean hasNetwork, boolean hasOnlineTemplates, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> templatesFlow, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> imagesReadyFlow, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> localDataReadyFlow) {
    }
}