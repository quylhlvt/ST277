package com.duomaker.couplelove.vatar;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/duomaker/couplelove/vatar/MyApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class MyApplication extends android.app.Application {
    private static com.duomaker.couplelove.vatar.MyApplication instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.MyApplication.Companion Companion = null;
    
    public MyApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/duomaker/couplelove/vatar/MyApplication$Companion;", "", "()V", "<set-?>", "Lcom/duomaker/couplelove/vatar/MyApplication;", "instance", "getInstance", "()Lcom/duomaker/couplelove/vatar/MyApplication;", "isTablet", "", "()Z", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.duomaker.couplelove.vatar.MyApplication getInstance() {
            return null;
        }
        
        public final boolean isTablet() {
            return false;
        }
    }
}