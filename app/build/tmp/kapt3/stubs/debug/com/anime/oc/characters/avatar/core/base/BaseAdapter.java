package com.anime.oc.characters.avatar.core.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0018\u0012\u0014\u0012\u00120\u0005R\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00000\u0004:\u0001&B%\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0011H$\u00a2\u0006\u0002\u0010\u0017J3\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014\u00a2\u0006\u0002\u0010\u001cJ(\u0010\u001d\u001a\u00020\u00132\u0016\u0010\u001e\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J6\u0010\u001d\u001a\u00020\u00132\u0016\u0010\u001e\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001fH\u0016J(\u0010 \u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0011H\u0016J \u0010#\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\b\u0002\u0010%\u001a\u00020\nH\u0007R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\'"}, d2 = {"Lcom/anime/oc/characters/avatar/core/base/BaseAdapter;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/anime/oc/characters/avatar/core/base/BaseAdapter$BaseViewHolder;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "items", "Ljava/util/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "getItemCount", "", "onBind", "", "binding", "item", "position", "(Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;I)V", "onBindPayload", "payloads", "", "", "(Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;ILjava/util/List;)V", "onBindViewHolder", "holder", "", "onCreateViewHolder", "parent", "viewType", "submitList", "list", "isNotChang", "BaseViewHolder", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public abstract class BaseAdapter<T extends java.lang.Object, VB extends androidx.viewbinding.ViewBinding> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.anime.oc.characters.avatar.core.base.BaseAdapter<T, VB>.BaseViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, VB> bindingInflater = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<T> items = null;
    
    public BaseAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, ? extends VB> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<T> getItems() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.anime.oc.characters.avatar.core.base.BaseAdapter<T, VB>.BaseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.core.base.BaseAdapter<T, VB>.BaseViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.core.base.BaseAdapter<T, VB>.BaseViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list, boolean isNotChang) {
    }
    
    protected void onBindPayload(@org.jetbrains.annotations.NotNull()
    VB binding, T item, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> payloads) {
    }
    
    protected abstract void onBind(@org.jetbrains.annotations.NotNull()
    VB binding, T item, int position);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u0013\u0010\u0002\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/anime/oc/characters/avatar/core/base/BaseAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "(Lcom/anime/oc/characters/avatar/core/base/BaseAdapter;Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "bindItem", "", "item", "position", "", "(Ljava/lang/Object;I)V", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    public final class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final VB binding = null;
        
        public BaseViewHolder(@org.jetbrains.annotations.NotNull()
        VB binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final VB getBinding() {
            return null;
        }
        
        public final void bindItem(T item, int position) {
        }
    }
}