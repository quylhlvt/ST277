package com.anime.oc.characters.avatar.core.custom.listener.listenerdraw;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\u0010\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/anime/oc/characters/avatar/core/custom/listener/listenerdraw/VideoEncoder;", "", "context", "Landroid/content/Context;", "listDrawView", "", "Lcom/anime/oc/characters/avatar/core/custom/DrawView;", "outputFilePath", "", "frameRate", "", "callback", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "bitRate", "height", "width", "performEncoding", "startEncoding", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class VideoEncoder {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.anime.oc.characters.avatar.core.custom.DrawView> listDrawView = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String outputFilePath = null;
    private final int frameRate = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.String, kotlin.Unit> callback = null;
    private final int width = 0;
    private final int height = 0;
    private final int bitRate = 6000000;
    
    public VideoEncoder(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.anime.oc.characters.avatar.core.custom.DrawView> listDrawView, @org.jetbrains.annotations.NotNull()
    java.lang.String outputFilePath, int frameRate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> callback) {
        super();
    }
    
    public final void startEncoding() {
    }
    
    private final void performEncoding() {
    }
}