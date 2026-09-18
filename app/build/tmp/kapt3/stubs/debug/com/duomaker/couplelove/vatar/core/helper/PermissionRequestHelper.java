package com.duomaker.couplelove.vatar.core.helper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/helper/PermissionRequestHelper;", "", "()V", "requestCount", "", "onDenied", "", "onGranted", "reset", "shouldGoToSettings", "", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class PermissionRequestHelper {
    private int requestCount = 0;
    public static final int MAX_REQUEST = 2;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.core.helper.PermissionRequestHelper.Companion Companion = null;
    
    public PermissionRequestHelper() {
        super();
    }
    
    public final void onDenied() {
    }
    
    public final void onGranted() {
    }
    
    public final boolean shouldGoToSettings() {
        return false;
    }
    
    public final void reset() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/helper/PermissionRequestHelper$Companion;", "", "()V", "MAX_REQUEST", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}