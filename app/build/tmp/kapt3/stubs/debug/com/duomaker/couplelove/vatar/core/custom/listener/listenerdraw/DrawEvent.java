package com.duomaker.couplelove.vatar.core.custom.listener.listenerdraw;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/custom/listener/listenerdraw/DrawEvent;", "", "onActionDown", "", "tattooView", "Lcom/duomaker/couplelove/vatar/core/custom/DrawView;", "event", "Landroid/view/MotionEvent;", "onActionMove", "onActionUp", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public abstract interface DrawEvent {
    
    public abstract void onActionDown(@org.jetbrains.annotations.Nullable()
    com.duomaker.couplelove.vatar.core.custom.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event);
    
    public abstract void onActionMove(@org.jetbrains.annotations.Nullable()
    com.duomaker.couplelove.vatar.core.custom.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event);
    
    public abstract void onActionUp(@org.jetbrains.annotations.Nullable()
    com.duomaker.couplelove.vatar.core.custom.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event);
}