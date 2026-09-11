package com.anime.oc.characters.avatar.core.extention;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\'H\u0002J\b\u0010+\u001a\u00020\'H\u0014J\b\u0010,\u001a\u00020\'H\u0014J\u0010\u0010-\u001a\u00020\'2\u0006\u0010.\u001a\u00020/H\u0014J(\u00100\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u000e\u00103\u001a\u00020\'2\u0006\u00104\u001a\u00020 J\u0010\u00105\u001a\u00020\'2\b\u00106\u001a\u0004\u0018\u00010\u000fJ\u0006\u00107\u001a\u00020\'R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/anime/oc/characters/avatar/core/extention/CurvedTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAngle", "", "clipLeft", "clipRight", "curveDepth", "fontFamily", "Landroid/graphics/Typeface;", "handler", "Landroid/os/Handler;", "hasValidSize", "", "isMarqueeRunning", "marqueeRunnable", "Ljava/lang/Runnable;", "marqueeSpeed", "oval", "Landroid/graphics/RectF;", "paintText", "Landroid/graphics/Paint;", "scrollOffset", "strokeColor", "strokeWidth", "text", "", "textColor", "textPath", "Landroid/graphics/Path;", "textSize", "textWidth", "buildArcPath", "", "w", "h", "checkMarquee", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "oldw", "oldh", "setText", "newText", "setTypeface", "tf", "startMarqueeWhenVisible", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class CurvedTextView extends android.view.View {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Path textPath = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.RectF oval = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paintText = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String text = "";
    private float textSize;
    private int textColor = android.graphics.Color.WHITE;
    private float curveDepth = 0.12F;
    private float centerAngle = -90.0F;
    private float strokeWidth = 0.0F;
    private int strokeColor = android.graphics.Color.BLACK;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Typeface fontFamily;
    private float scrollOffset = 0.0F;
    private float textWidth = 0.0F;
    private boolean isMarqueeRunning = false;
    private final float marqueeSpeed = 1.5F;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private float clipLeft = 0.0F;
    private float clipRight = 0.0F;
    private boolean hasValidSize = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable marqueeRunnable = null;
    
    @kotlin.jvm.JvmOverloads()
    public CurvedTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public CurvedTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public CurvedTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    private final void buildArcPath(float w, float h) {
    }
    
    private final void checkMarquee() {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    public final void startMarqueeWhenVisible() {
    }
    
    public final void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String newText) {
    }
    
    public final void setTypeface(@org.jetbrains.annotations.Nullable()
    android.graphics.Typeface tf) {
    }
}