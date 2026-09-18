package com.duomaker.couplelove.vatar.utils.share;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u000b\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "shareImage", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult;", "imagePath", "", "app", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$SocialApp;", "ShareResult", "SocialApp", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class SocialShareManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public SocialShareManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult shareImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp app) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult;", "", "AppNotAvailable", "Failed", "ImageNotFound", "Started", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$AppNotAvailable;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$Failed;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$ImageNotFound;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$Started;", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static abstract interface ShareResult {
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$AppNotAvailable;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult;", "app", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$SocialApp;", "(Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$SocialApp;)V", "getApp", "()Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$SocialApp;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
        public static final class AppNotAvailable implements com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult {
            @org.jetbrains.annotations.NotNull()
            private final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp app = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult.AppNotAvailable copy(@org.jetbrains.annotations.NotNull()
            com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp app) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
            
            public AppNotAvailable(@org.jetbrains.annotations.NotNull()
            com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp app) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp getApp() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$Failed;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
        public static final class Failed implements com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.Throwable error = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult.Failed copy(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable error) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
            
            public Failed(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable error) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable getError() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$ImageNotFound;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
        public static final class ImageNotFound implements com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult {
            @org.jetbrains.annotations.NotNull()
            public static final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult.ImageNotFound INSTANCE = null;
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
            
            private ImageNotFound() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult$Started;", "Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$ShareResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
        public static final class Started implements com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult {
            @org.jetbrains.annotations.NotNull()
            public static final com.duomaker.couplelove.vatar.utils.share.SocialShareManager.ShareResult.Started INSTANCE = null;
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
            
            private Started() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/duomaker/couplelove/vatar/utils/share/SocialShareManager$SocialApp;", "", "packageName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "FACEBOOK", "INSTAGRAM", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static enum SocialApp {
        /*public static final*/ FACEBOOK /* = new FACEBOOK(null) */,
        /*public static final*/ INSTAGRAM /* = new INSTAGRAM(null) */;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String packageName = null;
        
        SocialApp(java.lang.String packageName) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPackageName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.duomaker.couplelove.vatar.utils.share.SocialShareManager.SocialApp> getEntries() {
            return null;
        }
    }
}