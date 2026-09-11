package com.anime.oc.characters.avatar.ui.main.add_character.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0014J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/StickerAdapter;", "Lcom/anime/oc/characters/avatar/core/base/BaseAdapter;", "Lcom/anime/oc/characters/avatar/data/model/addcharacter/SelectedAddModel;", "Lcom/anime/oc/characters/avatar/databinding/ItemStickerBinding;", "()V", "currentSelected", "", "getCurrentSelected", "()I", "setCurrentSelected", "(I)V", "onItemClick", "Lkotlin/Function1;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onBind", "binding", "item", "position", "selectItem", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class StickerAdapter extends com.anime.oc.characters.avatar.core.base.BaseAdapter<com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel, com.anime.oc.characters.avatar.databinding.ItemStickerBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onItemClick;
    private int currentSelected = -1;
    
    public StickerAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    public final int getCurrentSelected() {
        return 0;
    }
    
    public final void setCurrentSelected(int p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.databinding.ItemStickerBinding binding, @org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel item, int position) {
    }
    
    public final void selectItem(int position) {
    }
}