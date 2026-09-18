package com.duomaker.couplelove.vatar.core.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0019H&J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0019H&J\b\u0010 \u001a\u00020\u0019H\u0002R\u001c\u0010\f\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0012\u0010\u0015\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/base/BaseDialog;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "gravity", "", "maxWidth", "", "maxHeight", "(Landroid/content/Context;IZZ)V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "isCancelOnTouchOutside", "()Z", "isCancelableByBack", "layoutId", "getLayoutId", "()I", "dismiss", "", "initAction", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismissListener", "setupWindow", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public abstract class BaseDialog<VB extends androidx.viewbinding.ViewBinding> extends android.app.Dialog {
    private final int gravity = 0;
    private final boolean maxWidth = false;
    private final boolean maxHeight = false;
    protected VB binding;
    
    public BaseDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int gravity, boolean maxWidth, boolean maxHeight) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VB getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    VB p0) {
    }
    
    public abstract int getLayoutId();
    
    public abstract boolean isCancelOnTouchOutside();
    
    public abstract boolean isCancelableByBack();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupWindow() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    public abstract void initView();
    
    public abstract void initAction();
    
    public abstract void onDismissListener();
}