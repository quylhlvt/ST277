package com.anime.oc.characters.avatar.ui.onboarding.permission;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionViewModel;", "Landroidx/lifecycle/ViewModel;", "permissionState", "Lcom/anime/oc/characters/avatar/core/helper/PermissionRequestState;", "(Lcom/anime/oc/characters/avatar/core/helper/PermissionRequestState;)V", "notificationDenyCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "getNotificationDenyCount", "()Lkotlinx/coroutines/flow/StateFlow;", "storageDenyCount", "getStorageDenyCount", "getNotificationPermissions", "", "", "()[Ljava/lang/String;", "getStoragePermissions", "onNotificationDenied", "", "onNotificationGranted", "onStorageDenied", "onStorageGranted", "shouldGoToSettings", "", "isStorage", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PermissionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.anime.oc.characters.avatar.core.helper.PermissionRequestState permissionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> storageDenyCount = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> notificationDenyCount = null;
    
    @javax.inject.Inject()
    public PermissionViewModel(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.core.helper.PermissionRequestState permissionState) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getStorageDenyCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getNotificationDenyCount() {
        return null;
    }
    
    public final void onStorageDenied() {
    }
    
    public final void onStorageGranted() {
    }
    
    public final void onNotificationDenied() {
    }
    
    public final void onNotificationGranted() {
    }
    
    public final boolean shouldGoToSettings(boolean isStorage) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getStoragePermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getNotificationPermissions() {
        return null;
    }
}