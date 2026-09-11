package com.anime.oc.characters.avatar.ui.onboarding.permission;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016J+\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\tH\u0014J\b\u0010!\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\tH\u0016J\f\u0010%\u001a\u00020\t*\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityPermissionBinding;", "Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionViewModel;", "()V", "pendingPermissionRequest", "", "pendingStorageRequest", "bindViewModel", "", "createColoredText", "Landroid/text/SpannableString;", "textRes", "", "colorRes", "font", "handleBackPressed", "handleContinue", "handlePermissionRequest", "isStorage", "initText", "initView", "isNetworkAvailable", "observeData", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "updateContinueMargin", "updatePermissionUI", "granted", "viewListener", "setupActionBar", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class PermissionActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityPermissionBinding, com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel> {
    private boolean pendingPermissionRequest = false;
    private boolean pendingStorageRequest = false;
    
    public PermissionActivity() {
        super(null, null);
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    private final boolean isNetworkAvailable() {
        return false;
    }
    
    private final void updateContinueMargin() {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void setupActionBar(com.anime.oc.characters.avatar.databinding.ActivityPermissionBinding $this$setupActionBar) {
    }
    
    private final void handlePermissionRequest(boolean isStorage) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void updatePermissionUI(boolean granted, boolean isStorage) {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    public void initText() {
    }
    
    private final void handleContinue() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    private final android.text.SpannableString createColoredText(@androidx.annotation.StringRes()
    int textRes, @androidx.annotation.ColorRes()
    int colorRes, int font) {
        return null;
    }
    
    @java.lang.Override()
    protected boolean handleBackPressed() {
        return false;
    }
}