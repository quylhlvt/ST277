package com.duomaker.couplelove.vatar.ui.main.add_character.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\rJ \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0014J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/StickerAdapter;", "Lcom/duomaker/couplelove/vatar/core/base/BaseAdapter;", "Lcom/duomaker/couplelove/vatar/data/model/addcharacter/SelectedAddModel;", "Lcom/duomaker/couplelove/vatar/databinding/ItemStickerBinding;", "()V", "<set-?>", "", "currentSelected", "getCurrentSelected", "()I", "onItemClick", "Lkotlin/Function2;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "clearSelection", "onBind", "binding", "item", "position", "selectItem", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class StickerAdapter extends com.duomaker.couplelove.vatar.core.base.BaseAdapter<com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel, com.duomaker.couplelove.vatar.databinding.ItemStickerBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onItemClick;
    private int currentSelected = -1;
    
    public StickerAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Integer, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final int getCurrentSelected() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.databinding.ItemStickerBinding binding, @org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel item, int position) {
    }
    
    public final void selectItem(int position) {
    }
    
    public final void clearSelection() {
    }
}