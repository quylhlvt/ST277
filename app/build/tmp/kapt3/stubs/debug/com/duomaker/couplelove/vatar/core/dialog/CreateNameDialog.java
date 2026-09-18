package com.duomaker.couplelove.vatar.core.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00120\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/dialog/CreateNameDialog;", "Lcom/duomaker/couplelove/vatar/core/base/BaseDialog;", "Lcom/duomaker/couplelove/vatar/databinding/DialogCreateNameBinding;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "layoutId", "", "getLayoutId", "()I", "onDismissClick", "Lkotlin/Function0;", "", "getOnDismissClick", "()Lkotlin/jvm/functions/Function0;", "setOnDismissClick", "(Lkotlin/jvm/functions/Function0;)V", "onNoClick", "getOnNoClick", "setOnNoClick", "onYesClick", "Lkotlin/Function1;", "", "getOnYesClick", "()Lkotlin/jvm/functions/Function1;", "setOnYesClick", "(Lkotlin/jvm/functions/Function1;)V", "initAction", "initView", "onDismissListener", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class CreateNameDialog extends com.duomaker.couplelove.vatar.core.base.BaseDialog<com.duomaker.couplelove.vatar.databinding.DialogCreateNameBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity context = null;
    private final int layoutId = 0;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onNoClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onYesClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onDismissClick;
    
    public CreateNameDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
        super(null, 0, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getContext() {
        return null;
    }
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isCancelOnTouchOutside() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCancelableByBack() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnNoClick() {
        return null;
    }
    
    public final void setOnNoClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnYesClick() {
        return null;
    }
    
    public final void setOnYesClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDismissClick() {
        return null;
    }
    
    public final void setOnDismissClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    public void initAction() {
    }
    
    @java.lang.Override()
    public void onDismissListener() {
    }
}