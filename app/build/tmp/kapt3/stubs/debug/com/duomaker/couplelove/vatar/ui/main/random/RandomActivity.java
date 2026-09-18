package com.duomaker.couplelove.vatar.ui.main.random;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0016\u0010\u0014\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\nH\u0014J\b\u0010\u001c\u001a\u00020\nH\u0014J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\nH\u0016J\f\u0010,\u001a\u00020\n*\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/random/RandomActivity;", "Lcom/duomaker/couplelove/vatar/core/base/BaseActivity;", "Lcom/duomaker/couplelove/vatar/databinding/ActivityRandomBinding;", "Lcom/duomaker/couplelove/vatar/ui/main/random/RandomViewModel;", "()V", "randomRequested", "", "renderJob", "Lkotlinx/coroutines/Job;", "bindViewModel", "", "cachedBitmapFor", "Landroid/graphics/Bitmap;", "item", "Lcom/duomaker/couplelove/vatar/ui/main/random/RandomViewModel$RandomItem;", "checkOnlineNetworkOrShowDialog", "templateId", "", "hasUsableNetwork", "initView", "mergeBitmaps", "bitmaps", "", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "renderCharacter", "requestRandomCharacter", "setControlsEnabled", "canEdit", "canRandom", "setEditActionBarEnabled", "enabled", "setupBackPressHandler", "setupPreViews", "showBitmap", "bitmap", "showLoading", "showRenderFailure", "showNetworkDialog", "viewListener", "setupActionBar", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class RandomActivity extends com.duomaker.couplelove.vatar.core.base.BaseActivity<com.duomaker.couplelove.vatar.databinding.ActivityRandomBinding, com.duomaker.couplelove.vatar.ui.main.random.RandomViewModel> {
    private static final int RENDER_SIZE = 800;
    private static final long RENDER_TIMEOUT_MS = 15000L;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job renderJob;
    
    /**
     * Random generation is started only after the user presses Random.
     */
    private boolean randomRequested = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.ui.main.random.RandomActivity.Companion Companion = null;
    
    public RandomActivity() {
        super(null, null);
    }
    
    private final boolean hasUsableNetwork() {
        return false;
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
    
    private final void setupActionBar(com.duomaker.couplelove.vatar.databinding.ActivityRandomBinding $this$setupActionBar) {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    private final void requestRandomCharacter() {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final android.graphics.Bitmap cachedBitmapFor(com.duomaker.couplelove.vatar.ui.main.random.RandomViewModel.RandomItem item) {
        return null;
    }
    
    private final void renderCharacter(com.duomaker.couplelove.vatar.ui.main.random.RandomViewModel.RandomItem item) {
    }
    
    private final void showRenderFailure(boolean showNetworkDialog) {
    }
    
    private final void showLoading() {
    }
    
    private final void showBitmap(android.graphics.Bitmap bitmap) {
    }
    
    private final void setControlsEnabled(boolean canEdit, boolean canRandom) {
    }
    
    private final void setEditActionBarEnabled(boolean enabled) {
    }
    
    private final android.graphics.Bitmap mergeBitmaps(java.util.List<android.graphics.Bitmap> bitmaps) {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/random/RandomActivity$Companion;", "", "()V", "RENDER_SIZE", "", "RENDER_TIMEOUT_MS", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}