package com.anime.oc.characters.avatar.ui.main.view;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020&H\u0014J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020&H\u0002J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020&H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/view/ViewActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityViewBinding;", "Lcom/anime/oc/characters/avatar/ui/main/view/ViewViewModel;", "()V", "currentImagePath", "", "downloadPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "idEdit", "getIdEdit", "()Ljava/lang/String;", "idEdit$delegate", "Lkotlin/Lazy;", "imagePath", "getImagePath", "imagePath$delegate", "imageType", "", "getImageType", "()I", "imageType$delegate", "isReturningFromExternalScreen", "", "permissionViewModel", "Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionViewModel;", "getPermissionViewModel", "()Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionViewModel;", "permissionViewModel$delegate", "socialShareManager", "Lcom/anime/oc/characters/avatar/utils/share/SocialShareManager;", "getSocialShareManager", "()Lcom/anime/oc/characters/avatar/utils/share/SocialShareManager;", "socialShareManager$delegate", "storageHelper", "Lcom/anime/oc/characters/avatar/core/helper/PermissionRequestHelper;", "bindViewModel", "", "confirmDelete", "downloadImage", "initView", "logSocialShareEvent", "socialName", "navigateToEdit", "observeData", "onResume", "performDownload", "restoreViewInteractions", "restoreWindowInteractions", "shareImage", "shareToSocialApp", "app", "Lcom/anime/oc/characters/avatar/utils/share/SocialShareManager$SocialApp;", "showEditItemNotFoundDialog", "showToast", "msg", "viewListener", "Companion", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class ViewActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityViewBinding, com.anime.oc.characters.avatar.ui.main.view.ViewViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final com.anime.oc.characters.avatar.core.helper.PermissionRequestHelper storageHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy socialShareManager$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentImagePath = "";
    private boolean isReturningFromExternalScreen = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy imagePath$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy imageType$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy idEdit$delegate = null;
    private static final long EXTERNAL_SCREEN_RESTORE_DELAY_MS = 500L;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.anime.oc.characters.avatar.ui.main.view.ViewActivity.Companion Companion = null;
    
    public ViewActivity() {
        super(null, null);
    }
    
    private final com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel getPermissionViewModel() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.utils.share.SocialShareManager getSocialShareManager() {
        return null;
    }
    
    private final java.lang.String getImagePath() {
        return null;
    }
    
    private final int getImageType() {
        return 0;
    }
    
    private final java.lang.String getIdEdit() {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void restoreViewInteractions() {
    }
    
    private final void restoreWindowInteractions() {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    private final void logSocialShareEvent(java.lang.String socialName) {
    }
    
    private final void shareToSocialApp(com.anime.oc.characters.avatar.utils.share.SocialShareManager.SocialApp app) {
    }
    
    private final void shareImage() {
    }
    
    private final void downloadImage() {
    }
    
    private final void performDownload() {
    }
    
    private final void confirmDelete() {
    }
    
    private final void navigateToEdit() {
    }
    
    private final void showEditItemNotFoundDialog() {
    }
    
    private final void showToast(java.lang.String msg) {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/view/ViewActivity$Companion;", "", "()V", "EXTERNAL_SCREEN_RESTORE_DELAY_MS", "", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}