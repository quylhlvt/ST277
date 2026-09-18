package com.duomaker.couplelove.vatar.ui.main.cosplay;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0016\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u000bH\u0014J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0006H\u0002J\b\u0010\'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0016J\f\u0010.\u001a\u00020\u000b*\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/cosplay/CosplayActivity;", "Lcom/duomaker/couplelove/vatar/core/base/BaseActivity;", "Lcom/duomaker/couplelove/vatar/databinding/ActivityCosplayBinding;", "Lcom/duomaker/couplelove/vatar/ui/main/cosplay/CosplayViewModel;", "()V", "randomRequestPending", "", "renderJob", "Lkotlinx/coroutines/Job;", "startChallengeWhenReady", "bindViewModel", "", "cachedBitmapFor", "Landroid/graphics/Bitmap;", "item", "Lcom/duomaker/couplelove/vatar/ui/main/cosplay/CosplayViewModel$RandomItem;", "checkOnlineNetworkOrShowDialog", "templateId", "", "hasUsableNetwork", "initView", "mergeBitmaps", "bitmaps", "", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onSaveInstanceState", "outState", "renderCharacter", "requestRandomCharacter", "isOnline", "setControlsEnabled", "canShow", "canRandom", "setShowButtonEnabled", "enabled", "setupBackPressHandler", "setupPreViews", "showBitmap", "bitmap", "showLoading", "startChallenge", "viewListener", "setupActionBar", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class CosplayActivity extends com.duomaker.couplelove.vatar.core.base.BaseActivity<com.duomaker.couplelove.vatar.databinding.ActivityCosplayBinding, com.duomaker.couplelove.vatar.ui.main.cosplay.CosplayViewModel> {
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job renderJob;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_START_CHALLENGE = "start_challenge";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATE_START_CHALLENGE = "pending_challenge";
    private static final long MISSING_LAYER_RETRY_DELAY_MS = 700L;
    private static final long NETWORK_RECHECK_DELAY_MS = 500L;
    private boolean startChallengeWhenReady = false;
    private boolean randomRequestPending = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.ui.main.cosplay.CosplayActivity.Companion Companion = null;
    
    public CosplayActivity() {
        super(null, null);
    }
    
    private final boolean hasUsableNetwork() {
        return false;
    }
    
    private final boolean requestRandomCharacter(boolean isOnline) {
        return false;
    }
    
    private final void startChallenge() {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    private final boolean checkOnlineNetworkOrShowDialog(java.lang.String templateId) {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupBackPressHandler() {
    }
    
    @java.lang.Override()
    public void setupPreViews() {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void setupActionBar(com.duomaker.couplelove.vatar.databinding.ActivityCosplayBinding $this$setupActionBar) {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final android.graphics.Bitmap cachedBitmapFor(com.duomaker.couplelove.vatar.ui.main.cosplay.CosplayViewModel.RandomItem item) {
        return null;
    }
    
    private final void renderCharacter(com.duomaker.couplelove.vatar.ui.main.cosplay.CosplayViewModel.RandomItem item) {
    }
    
    private final void showLoading() {
    }
    
    private final void showBitmap(android.graphics.Bitmap bitmap) {
    }
    
    private final void setShowButtonEnabled(boolean enabled) {
    }
    
    private final void setControlsEnabled(boolean canShow, boolean canRandom) {
    }
    
    private final android.graphics.Bitmap mergeBitmaps(java.util.List<android.graphics.Bitmap> bitmaps) {
        return null;
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/cosplay/CosplayActivity$Companion;", "", "()V", "EXTRA_START_CHALLENGE", "", "MISSING_LAYER_RETRY_DELAY_MS", "", "NETWORK_RECHECK_DELAY_MS", "STATE_START_CHALLENGE", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}