package com.duomaker.couplelove.vatar.core.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/dialog/RateDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "_binding", "Lcom/duomaker/couplelove/vatar/databinding/DialogRateBinding;", "binding", "getBinding", "()Lcom/duomaker/couplelove/vatar/databinding/DialogRateBinding;", "onCancel", "Lkotlin/Function0;", "", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "setOnCancel", "(Lkotlin/jvm/functions/Function0;)V", "onRateGreater3", "getOnRateGreater3", "setOnRateGreater3", "onRateLess3", "getOnRateLess3", "setOnRateLess3", "rating", "", "ratingToast", "Landroid/widget/Toast;", "dismiss", "initAction", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "setView", "titleRes", "descRes", "imgRes", "show", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class RateDialog extends android.app.Dialog implements androidx.lifecycle.DefaultLifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.Nullable()
    private com.duomaker.couplelove.vatar.databinding.DialogRateBinding _binding;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRateGreater3;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRateLess3;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onCancel;
    private int rating = 0;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Toast ratingToast;
    
    public RateDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super(null);
    }
    
    private final com.duomaker.couplelove.vatar.databinding.DialogRateBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnRateGreater3() {
        return null;
    }
    
    public final void setOnRateGreater3(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnRateLess3() {
        return null;
    }
    
    public final void setOnRateLess3(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnCancel() {
        return null;
    }
    
    public final void setOnCancel(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void initAction() {
    }
    
    private final void setView(int titleRes, int descRes, int imgRes) {
    }
    
    @java.lang.Override()
    public void show() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    @java.lang.Override()
    public void onDestroy(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner) {
    }
}