package com.anime.oc.characters.avatar.ui.main.random;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\bH\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\bH\u0016J\f\u0010\"\u001a\u00020\b*\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/random/RandomActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityRandomBinding;", "Lcom/anime/oc/characters/avatar/ui/main/random/RandomViewModel;", "()V", "randomClickCount", "", "bindViewModel", "", "checkOnlineNetworkOrShowDialog", "", "templateIndex", "initView", "isOnlineTemplate", "mergeBitmaps", "Landroid/graphics/Bitmap;", "bitmaps", "", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "renderCharacter", "item", "Lcom/anime/oc/characters/avatar/ui/main/random/RandomViewModel$RandomItem;", "setSaveButtonEnabled", "enabled", "setupBackPressHandler", "setupPreViews", "showBitmap", "bitmap", "showLoading", "viewListener", "setupActionBar", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class RandomActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityRandomBinding, com.anime.oc.characters.avatar.ui.main.random.RandomViewModel> {
    private int randomClickCount = 0;
    
    public RandomActivity() {
        super(null, null);
    }
    
    private final boolean isOnlineTemplate(int templateIndex) {
        return false;
    }
    
    private final boolean checkOnlineNetworkOrShowDialog(int templateIndex) {
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
    
    private final void setupActionBar(com.anime.oc.characters.avatar.databinding.ActivityRandomBinding $this$setupActionBar) {
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
    
    private final void renderCharacter(com.anime.oc.characters.avatar.ui.main.random.RandomViewModel.RandomItem item) {
    }
    
    private final void showLoading() {
    }
    
    private final void showBitmap(android.graphics.Bitmap bitmap) {
    }
    
    private final void setSaveButtonEnabled(boolean enabled) {
    }
    
    private final android.graphics.Bitmap mergeBitmaps(java.util.List<android.graphics.Bitmap> bitmaps) {
        return null;
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
}