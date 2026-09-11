package com.anime.oc.characters.avatar.ui.main.random;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0014J \u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\tJ0\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0002J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/random/RandomViewModel;", "Landroidx/lifecycle/ViewModel;", "appDataManager", "Lcom/anime/oc/characters/avatar/data/datalocal/manager/AppDataManager;", "(Lcom/anime/oc/characters/avatar/data/datalocal/manager/AppDataManager;)V", "_cachedBitmap", "Landroid/graphics/Bitmap;", "_isDataReady", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_randomItem", "Lcom/anime/oc/characters/avatar/ui/main/random/RandomViewModel$RandomItem;", "cachedBitmap", "getCachedBitmap", "()Landroid/graphics/Bitmap;", "isDataReady", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "randomItem", "getRandomItem", "onCleared", "", "randomSelections", "Ljava/util/ArrayList;", "Lcom/anime/oc/characters/avatar/data/model/custom/SelectionIndex;", "Lkotlin/collections/ArrayList;", "template", "Lcom/anime/oc/characters/avatar/data/model/custom/CustomModel;", "randomize", "isOnline", "resolvePaths", "", "", "sel", "setCachedBitmap", "bmp", "RandomItem", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RandomViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager appDataManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDataReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDataReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.anime.oc.characters.avatar.ui.main.random.RandomViewModel.RandomItem> _randomItem = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.anime.oc.characters.avatar.ui.main.random.RandomViewModel.RandomItem> randomItem = null;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap _cachedBitmap;
    
    @javax.inject.Inject()
    public RandomViewModel(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager appDataManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDataReady() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.anime.oc.characters.avatar.ui.main.random.RandomViewModel.RandomItem> getRandomItem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getCachedBitmap() {
        return null;
    }
    
    public final void setCachedBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bmp) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void randomize(boolean isOnline) {
    }
    
    private final java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> randomSelections(com.anime.oc.characters.avatar.data.model.custom.CustomModel template) {
        return null;
    }
    
    private final java.util.List<java.lang.String> resolvePaths(com.anime.oc.characters.avatar.data.model.custom.CustomModel template, java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> sel) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u00c6\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u00c6\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\fH\u00d6\u0001R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/random/RandomViewModel$RandomItem;", "", "templateIndex", "", "template", "Lcom/anime/oc/characters/avatar/data/model/custom/CustomModel;", "selections", "Ljava/util/ArrayList;", "Lcom/anime/oc/characters/avatar/data/model/custom/SelectionIndex;", "Lkotlin/collections/ArrayList;", "resolvedPaths", "", "", "(ILcom/anime/oc/characters/avatar/data/model/custom/CustomModel;Ljava/util/ArrayList;Ljava/util/List;)V", "getResolvedPaths", "()Ljava/util/List;", "getSelections", "()Ljava/util/ArrayList;", "getTemplate", "()Lcom/anime/oc/characters/avatar/data/model/custom/CustomModel;", "getTemplateIndex", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    public static final class RandomItem {
        private final int templateIndex = 0;
        @org.jetbrains.annotations.NotNull()
        private final com.anime.oc.characters.avatar.data.model.custom.CustomModel template = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> selections = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> resolvedPaths = null;
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.anime.oc.characters.avatar.data.model.custom.CustomModel component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.anime.oc.characters.avatar.ui.main.random.RandomViewModel.RandomItem copy(int templateIndex, @org.jetbrains.annotations.NotNull()
        com.anime.oc.characters.avatar.data.model.custom.CustomModel template, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> selections, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> resolvedPaths) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
        
        public RandomItem(int templateIndex, @org.jetbrains.annotations.NotNull()
        com.anime.oc.characters.avatar.data.model.custom.CustomModel template, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> selections, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> resolvedPaths) {
            super();
        }
        
        public final int getTemplateIndex() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.anime.oc.characters.avatar.data.model.custom.CustomModel getTemplate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> getSelections() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getResolvedPaths() {
            return null;
        }
    }
}