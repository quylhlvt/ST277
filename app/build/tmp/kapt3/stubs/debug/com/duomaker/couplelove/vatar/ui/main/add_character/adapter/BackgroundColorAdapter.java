package com.duomaker.couplelove.vatar.ui.main.add_character.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\rJ \u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0014J\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/BackgroundColorAdapter;", "Lcom/duomaker/couplelove/vatar/core/base/BaseAdapter;", "Lcom/duomaker/couplelove/vatar/data/model/addcharacter/SelectedAddModel;", "Lcom/duomaker/couplelove/vatar/databinding/ItemBackgroundColorBinding;", "()V", "currentSelected", "", "getCurrentSelected", "()I", "setCurrentSelected", "(I)V", "onBackgroundColorClick", "Lkotlin/Function2;", "", "getOnBackgroundColorClick", "()Lkotlin/jvm/functions/Function2;", "setOnBackgroundColorClick", "(Lkotlin/jvm/functions/Function2;)V", "onChooseColorClick", "Lkotlin/Function0;", "getOnChooseColorClick", "()Lkotlin/jvm/functions/Function0;", "setOnChooseColorClick", "(Lkotlin/jvm/functions/Function0;)V", "onNoneColorClick", "getOnNoneColorClick", "setOnNoneColorClick", "clearSelection", "onBind", "binding", "item", "position", "selectItem", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class BackgroundColorAdapter extends com.duomaker.couplelove.vatar.core.base.BaseAdapter<com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel, com.duomaker.couplelove.vatar.databinding.ItemBackgroundColorBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onNoneColorClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onChooseColorClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onBackgroundColorClick;
    private int currentSelected = -1;
    @java.lang.Deprecated()
    public static final int NONE_COLOR_POSITION = 0;
    @java.lang.Deprecated()
    public static final int ADD_COLOR_POSITION = 1;
    @org.jetbrains.annotations.NotNull()
    private static final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.BackgroundColorAdapter.Companion Companion = null;
    
    public BackgroundColorAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnNoneColorClick() {
        return null;
    }
    
    public final void setOnNoneColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnChooseColorClick() {
        return null;
    }
    
    public final void setOnChooseColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnBackgroundColorClick() {
        return null;
    }
    
    public final void setOnBackgroundColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final int getCurrentSelected() {
        return 0;
    }
    
    public final void setCurrentSelected(int p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.databinding.ItemBackgroundColorBinding binding, @org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel item, int position) {
    }
    
    public final void selectItem(int position) {
    }
    
    public final void clearSelection() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/BackgroundColorAdapter$Companion;", "", "()V", "ADD_COLOR_POSITION", "", "NONE_COLOR_POSITION", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}