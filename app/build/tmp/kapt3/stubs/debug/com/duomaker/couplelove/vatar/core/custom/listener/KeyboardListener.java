package com.duomaker.couplelove.vatar.core.custom.listener;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\fH\u0016R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/custom/listener/KeyboardListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activity", "Landroid/app/Activity;", "onKeyboardVisibilityChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isVisible", "", "keyboardHeight", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function2;)V", "lastVisible", "rootView", "Landroid/view/View;", "detach", "onGlobalLayout", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class KeyboardListener implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.Integer, kotlin.Unit> onKeyboardVisibilityChanged = null;
    @org.jetbrains.annotations.NotNull()
    private final android.view.View rootView = null;
    private boolean lastVisible = false;
    
    public KeyboardListener(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Integer, kotlin.Unit> onKeyboardVisibilityChanged) {
        super();
    }
    
    @java.lang.Override()
    public void onGlobalLayout() {
    }
    
    public final void detach() {
    }
}