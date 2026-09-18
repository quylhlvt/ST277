package com.duomaker.couplelove.vatar.ui.main.add_character.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0014J&\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001bJ \u0010\u001c\u001a\u00020\t2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR,\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/TextColorAdapter;", "Lcom/duomaker/couplelove/vatar/core/base/BaseAdapter;", "Lcom/duomaker/couplelove/vatar/data/model/addcharacter/SelectedAddModel;", "Lcom/duomaker/couplelove/vatar/databinding/ItemTextColorBinding;", "()V", "currentSelected", "", "onChooseColorClick", "Lkotlin/Function0;", "", "getOnChooseColorClick", "()Lkotlin/jvm/functions/Function0;", "setOnChooseColorClick", "(Lkotlin/jvm/functions/Function0;)V", "onTextColorClick", "Lkotlin/Function2;", "getOnTextColorClick", "()Lkotlin/jvm/functions/Function2;", "setOnTextColorClick", "(Lkotlin/jvm/functions/Function2;)V", "onBind", "binding", "item", "position", "submitItem", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "submitListReset", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class TextColorAdapter extends com.duomaker.couplelove.vatar.core.base.BaseAdapter<com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel, com.duomaker.couplelove.vatar.databinding.ItemTextColorBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onChooseColorClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onTextColorClick;
    private int currentSelected = 1;
    
    public TextColorAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnChooseColorClick() {
        return null;
    }
    
    public final void setOnChooseColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnTextColorClick() {
        return null;
    }
    
    public final void setOnTextColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.databinding.ItemTextColorBinding binding, @org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel item, int position) {
    }
    
    public final void submitItem(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel> list) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void submitListReset(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel> list) {
    }
}