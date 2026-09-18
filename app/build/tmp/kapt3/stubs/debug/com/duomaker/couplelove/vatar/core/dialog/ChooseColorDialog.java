package com.duomaker.couplelove.vatar.core.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/duomaker/couplelove/vatar/core/dialog/ChooseColorDialog;", "Lcom/duomaker/couplelove/vatar/core/base/BaseDialog;", "Lcom/duomaker/couplelove/vatar/databinding/DialogColorPickerBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "color", "", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "layoutId", "getLayoutId", "()I", "onCloseEvent", "Lkotlin/Function0;", "", "getOnCloseEvent", "()Lkotlin/jvm/functions/Function0;", "setOnCloseEvent", "(Lkotlin/jvm/functions/Function0;)V", "onDismissEvent", "getOnDismissEvent", "setOnDismissEvent", "onDoneEvent", "Lkotlin/Function1;", "getOnDoneEvent", "()Lkotlin/jvm/functions/Function1;", "setOnDoneEvent", "(Lkotlin/jvm/functions/Function1;)V", "initAction", "initView", "onDismissListener", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class ChooseColorDialog extends com.duomaker.couplelove.vatar.core.base.BaseDialog<com.duomaker.couplelove.vatar.databinding.DialogColorPickerBinding> {
    private final int layoutId = 0;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onDoneEvent;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onCloseEvent;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onDismissEvent;
    private int color = android.graphics.Color.WHITE;
    
    public ChooseColorDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, 0, false, false);
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
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnDoneEvent() {
        return null;
    }
    
    public final void setOnDoneEvent(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnCloseEvent() {
        return null;
    }
    
    public final void setOnCloseEvent(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDismissEvent() {
        return null;
    }
    
    public final void setOnDismissEvent(@org.jetbrains.annotations.NotNull()
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