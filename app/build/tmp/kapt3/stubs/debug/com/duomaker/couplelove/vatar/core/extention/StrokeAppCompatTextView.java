package com.duomaker.couplelove.vatar.core.extention;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J*\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007J*\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\nJ\b\u0010&\u001a\u00020\u0015H\u0002R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/extention/StrokeAppCompatTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fillEdgeCoverPx", "", "getFillEdgeCoverPx", "()F", "isInternalDrawing", "", "strokeColor", "strokeJoin", "Landroid/graphics/Paint$Join;", "strokeMiter", "strokeWidthPx", "invalidate", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "postInvalidate", "readAttributes", "setStroke", "widthPx", "color", "join", "miter", "setStrokeColor", "setStrokeDp", "widthDp", "setStrokeTitle", "setStrokeWidthDp", "setStrokeWidthPx", "updateLayerType", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class StrokeAppCompatTextView extends androidx.appcompat.widget.AppCompatTextView {
    private float strokeWidthPx = 0.0F;
    private int strokeColor = android.graphics.Color.WHITE;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Paint.Join strokeJoin = android.graphics.Paint.Join.ROUND;
    private float strokeMiter = 5.0F;
    private boolean isInternalDrawing = false;
    
    @kotlin.jvm.JvmOverloads()
    public StrokeAppCompatTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public StrokeAppCompatTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public StrokeAppCompatTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    private final float getFillEdgeCoverPx() {
        return 0.0F;
    }
    
    private final void readAttributes(android.util.AttributeSet attrs, int defStyleAttr) {
    }
    
    private final void updateLayerType() {
    }
    
    /**
     * widthPx được tính bằng pixel.
     */
    public final void setStroke(float widthPx, int color, @org.jetbrains.annotations.NotNull()
    android.graphics.Paint.Join join, float miter) {
    }
    
    /**
     * widthDp được tính bằng dp.
     */
    public final void setStrokeDp(float widthDp, int color, @org.jetbrains.annotations.NotNull()
    android.graphics.Paint.Join join, float miter) {
    }
    
    public final void setStrokeColor(int color) {
    }
    
    public final void setStrokeWidthPx(float widthPx) {
    }
    
    public final void setStrokeWidthDp(float widthDp) {
    }
    
    public final void setStrokeTitle() {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public void invalidate() {
    }
    
    @java.lang.Override()
    public void postInvalidate() {
    }
}