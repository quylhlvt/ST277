package com.anime.oc.characters.avatar.ui.main.cosplay;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\nH\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0016J\f\u0010\'\u001a\u00020\n*\u00020\u0002H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/cosplay/CosplayActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityCosplayBinding;", "Lcom/anime/oc/characters/avatar/ui/main/cosplay/CosplayViewModel;", "()V", "renderJob", "Lkotlinx/coroutines/Job;", "startChallengeWhenReady", "", "bindViewModel", "", "checkOnlineNetworkOrShowDialog", "templateIndex", "", "initView", "isOnlineTemplate", "mergeBitmaps", "Landroid/graphics/Bitmap;", "bitmaps", "", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onSaveInstanceState", "outState", "renderCharacter", "item", "Lcom/anime/oc/characters/avatar/ui/main/cosplay/CosplayViewModel$RandomItem;", "setShowButtonEnabled", "enabled", "setupBackPressHandler", "setupPreViews", "showBitmap", "bitmap", "showLoading", "startChallenge", "viewListener", "setupActionBar", "Companion", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class CosplayActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityCosplayBinding, com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel> {
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job renderJob;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_START_CHALLENGE = "start_challenge";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATE_START_CHALLENGE = "pending_challenge";
    private boolean startChallengeWhenReady = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.anime.oc.characters.avatar.ui.main.cosplay.CosplayActivity.Companion Companion = null;
    
    public CosplayActivity() {
        super(null, null);
    }
    
    private final void startChallenge() {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
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
    
    private final void setupActionBar(com.anime.oc.characters.avatar.databinding.ActivityCosplayBinding $this$setupActionBar) {
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
    
    private final void renderCharacter(com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel.RandomItem item) {
    }
    
    private final void showLoading() {
    }
    
    private final void showBitmap(android.graphics.Bitmap bitmap) {
    }
    
    private final void setShowButtonEnabled(boolean enabled) {
    }
    
    private final android.graphics.Bitmap mergeBitmaps(java.util.List<android.graphics.Bitmap> bitmaps) {
        return null;
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/cosplay/CosplayActivity$Companion;", "", "()V", "EXTRA_START_CHALLENGE", "", "STATE_START_CHALLENGE", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}