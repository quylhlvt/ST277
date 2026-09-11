package com.anime.oc.characters.avatar.ui.main.add_character.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\nH\u0014J&\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u0019J \u0010\u001a\u001a\u00020\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u0019H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/TextFontAdapter;", "Lcom/anime/oc/characters/avatar/core/base/BaseAdapter;", "Lcom/anime/oc/characters/avatar/data/model/addcharacter/SelectedAddModel;", "Lcom/anime/oc/characters/avatar/databinding/ItemFontBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "currentSelected", "", "onTextFontClick", "Lkotlin/Function2;", "", "getOnTextFontClick", "()Lkotlin/jvm/functions/Function2;", "setOnTextFontClick", "(Lkotlin/jvm/functions/Function2;)V", "onBind", "binding", "item", "position", "submitItem", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "submitListReset", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class TextFontAdapter extends com.anime.oc.characters.avatar.core.base.BaseAdapter<com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel, com.anime.oc.characters.avatar.databinding.ItemFontBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onTextFontClick;
    private int currentSelected = 0;
    
    public TextFontAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnTextFontClick() {
        return null;
    }
    
    public final void setOnTextFontClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.databinding.ItemFontBinding binding, @org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel item, int position) {
    }
    
    public final void submitItem(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel> list) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void submitListReset(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel> list) {
    }
}