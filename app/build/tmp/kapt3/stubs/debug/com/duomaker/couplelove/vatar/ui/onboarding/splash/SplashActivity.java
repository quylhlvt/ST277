package com.duomaker.couplelove.vatar.ui.onboarding.splash;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0014J\u0016\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/onboarding/splash/SplashActivity;", "Lcom/duomaker/couplelove/vatar/core/base/BaseActivity;", "Lcom/duomaker/couplelove/vatar/databinding/ActivitySplashBinding;", "Lcom/duomaker/couplelove/vatar/ui/onboarding/splash/SplashViewModel;", "()V", "currentOverlayFraction", "", "hasNavigated", "", "navigateJob", "Lkotlinx/coroutines/Job;", "pendingNavigate", "progressAnimator", "Landroid/animation/ValueAnimator;", "bindViewModel", "", "doNavigate", "goToHome", "handleBackPressed", "initView", "isNetworkAvailable", "observeData", "onDestroy", "onPause", "onResume", "preloadHomeDrawables", "onDone", "Lkotlin/Function0;", "viewListener", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class SplashActivity extends com.duomaker.couplelove.vatar.core.base.BaseActivity<com.duomaker.couplelove.vatar.databinding.ActivitySplashBinding, com.duomaker.couplelove.vatar.ui.onboarding.splash.SplashViewModel> {
    private boolean pendingNavigate = false;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job navigateJob;
    @org.jetbrains.annotations.Nullable()
    private android.animation.ValueAnimator progressAnimator;
    private float currentOverlayFraction = 1.0F;
    private boolean hasNavigated = false;
    private static final long MIN_SPLASH_MS = 3000L;
    private static final long API_TIMEOUT_MS = 8000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.ui.onboarding.splash.SplashActivity.Companion Companion = null;
    
    public SplashActivity() {
        super(null, null);
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void preloadHomeDrawables(kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    private final void goToHome() {
    }
    
    private final void doNavigate() {
    }
    
    private final boolean isNetworkAvailable() {
        return false;
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected boolean handleBackPressed() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/onboarding/splash/SplashActivity$Companion;", "", "()V", "API_TIMEOUT_MS", "", "MIN_SPLASH_MS", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}