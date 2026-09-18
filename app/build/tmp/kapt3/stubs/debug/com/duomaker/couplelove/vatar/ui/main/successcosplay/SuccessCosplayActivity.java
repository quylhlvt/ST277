package com.duomaker.couplelove.vatar.ui.main.successcosplay;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/successcosplay/SuccessCosplayActivity;", "Lcom/duomaker/couplelove/vatar/core/base/BaseActivity;", "Lcom/duomaker/couplelove/vatar/databinding/ActivitySuccessCosplayBinding;", "Lcom/duomaker/couplelove/vatar/ui/main/successcosplay/SuccessCosplayViewModel;", "()V", "downloadPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "permissionViewModel", "Lcom/duomaker/couplelove/vatar/ui/onboarding/permission/PermissionViewModel;", "getPermissionViewModel", "()Lcom/duomaker/couplelove/vatar/ui/onboarding/permission/PermissionViewModel;", "permissionViewModel$delegate", "Lkotlin/Lazy;", "resultImagePath", "bindViewModel", "", "downloadImage", "initView", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performDownload", "persistResultBitmap", "bitmap", "Landroid/graphics/Bitmap;", "replayShow", "setupBackPressHandler", "showToast", "message", "updateOccupancy", "percent", "", "viewListener", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class SuccessCosplayActivity extends com.duomaker.couplelove.vatar.core.base.BaseActivity<com.duomaker.couplelove.vatar.databinding.ActivitySuccessCosplayBinding, com.duomaker.couplelove.vatar.ui.main.successcosplay.SuccessCosplayViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String resultImagePath = "";
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    
    public SuccessCosplayActivity() {
        super(null, null);
    }
    
    private final com.duomaker.couplelove.vatar.ui.onboarding.permission.PermissionViewModel getPermissionViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupBackPressHandler() {
    }
    
    private final void replayShow() {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void updateOccupancy(int percent) {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    private final java.lang.String persistResultBitmap(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void downloadImage() {
    }
    
    private final void performDownload() {
    }
    
    private final void showToast(java.lang.String message) {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
}