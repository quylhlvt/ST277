package com.anime.oc.characters.avatar.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/anime/oc/characters/avatar/utils/BlockableFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isBlocked", "", "()Z", "setBlocked", "(Z)V", "addView", "", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class BlockableFrameLayout extends android.widget.FrameLayout {
    private boolean isBlocked = false;
    
    @kotlin.jvm.JvmOverloads()
    public BlockableFrameLayout(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public BlockableFrameLayout(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final boolean isBlocked() {
        return false;
    }
    
    public final void setBlocked(boolean p0) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.NotNull()
    android.view.View child) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.NotNull()
    android.view.View child, int index) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.NotNull()
    android.view.View child, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup.LayoutParams params) {
    }
}