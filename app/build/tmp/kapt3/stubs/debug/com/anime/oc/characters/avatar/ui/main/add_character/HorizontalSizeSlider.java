package com.anime.oc.characters.avatar.ui.main.add_character;

/**
 * Slider kích thước nằm ngang: track nhỏ bên trái và lớn dần về bên phải.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020#H\u0016J\b\u0010\'\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\tH\u0002R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/add_character/HorizontalSizeSlider;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onProgressChanged", "Lkotlin/Function1;", "", "", "getOnProgressChanged", "()Lkotlin/jvm/functions/Function1;", "setOnProgressChanged", "(Lkotlin/jvm/functions/Function1;)V", "value", "progress", "getProgress", "()F", "setProgress", "(F)V", "thumbPaint", "Landroid/graphics/Paint;", "thumbStrokePaint", "trackPaint", "trackPath", "Landroid/graphics/Path;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "performClick", "thumbRadius", "updateProgress", "touchX", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class HorizontalSizeSlider extends android.view.View {
    private float progress = 0.5F;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onProgressChanged;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint trackPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint thumbPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint thumbStrokePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Path trackPath = null;
    
    @kotlin.jvm.JvmOverloads()
    public HorizontalSizeSlider(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public HorizontalSizeSlider(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final float getProgress() {
        return 0.0F;
    }
    
    public final void setProgress(float value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> getOnProgressChanged() {
        return null;
    }
    
    public final void setOnProgressChanged(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public boolean performClick() {
        return false;
    }
    
    private final void updateProgress(float touchX) {
    }
    
    private final float thumbRadius() {
        return 0.0F;
    }
}