package com.anime.oc.characters.avatar.ui.main.myPony.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0018H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/myPony/adapter/MyAvatarAdapter;", "Lcom/anime/oc/characters/avatar/core/base/BaseAdapter;", "Lcom/anime/oc/characters/avatar/data/model/mypony/MyAlbumModel;", "Lcom/anime/oc/characters/avatar/databinding/ItemMyAvatarBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onDeleteClick", "Lkotlin/Function1;", "", "", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function1;", "setOnDeleteClick", "(Lkotlin/jvm/functions/Function1;)V", "onEditClick", "getOnEditClick", "setOnEditClick", "onItemClick", "getOnItemClick", "setOnItemClick", "onItemTick", "", "getOnItemTick", "setOnItemTick", "onLongClick", "getOnLongClick", "setOnLongClick", "onBind", "binding", "item", "position", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class MyAvatarAdapter extends com.anime.oc.characters.avatar.core.base.BaseAdapter<com.anime.oc.characters.avatar.data.model.mypony.MyAlbumModel, com.anime.oc.characters.avatar.databinding.ItemMyAvatarBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.anime.oc.characters.avatar.data.model.mypony.MyAlbumModel, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemTick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEditClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteClick;
    
    public MyAvatarAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.anime.oc.characters.avatar.data.model.mypony.MyAlbumModel, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.anime.oc.characters.avatar.data.model.mypony.MyAlbumModel, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnLongClick() {
        return null;
    }
    
    public final void setOnLongClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnItemTick() {
        return null;
    }
    
    public final void setOnItemTick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnEditClick() {
        return null;
    }
    
    public final void setOnEditClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnDeleteClick() {
        return null;
    }
    
    public final void setOnDeleteClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.databinding.ItemMyAvatarBinding binding, @org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.mypony.MyAlbumModel item, int position) {
    }
}