package com.anime.oc.characters.avatar;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u001eJ\u0006\u0010W\u001a\u00020UJ\u000e\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020\u001eJ\u0006\u0010Z\u001a\u00020UJ\u000e\u0010[\u001a\u00020UH\u0082@\u00a2\u0006\u0002\u0010\\J\u0006\u0010]\u001a\u00020UJ\u0010\u0010^\u001a\u0004\u0018\u00010(2\u0006\u0010_\u001a\u00020\u001eJ\u0010\u0010`\u001a\u0004\u0018\u00010(2\u0006\u0010a\u001a\u000201J\u000e\u0010b\u001a\u0002012\u0006\u0010_\u001a\u00020\u001eJ\u000e\u0010c\u001a\u0002012\u0006\u0010d\u001a\u00020\u001eJ\u000e\u0010e\u001a\u0002012\u0006\u0010f\u001a\u00020\u001eJ\u000e\u0010g\u001a\u00020\b2\u0006\u0010f\u001a\u00020\u001eJ\u000e\u0010h\u001a\u00020\b2\u0006\u0010_\u001a\u00020\u001eJ\u0006\u0010i\u001a\u00020UJ\b\u0010j\u001a\u00020kH\u0002J\b\u0010l\u001a\u00020UH\u0002J$\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00142\u0006\u0010n\u001a\u00020\u001e2\u0006\u0010o\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010pJ\u0006\u0010q\u001a\u00020UJ\u000e\u0010r\u001a\u00020UH\u0082@\u00a2\u0006\u0002\u0010\\J\u001c\u0010s\u001a\u00020U2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020(0\u0014H\u0082@\u00a2\u0006\u0002\u0010tJ\u0006\u0010u\u001a\u00020UJ\u0006\u0010v\u001a\u00020UJ\u000e\u0010w\u001a\u00020U2\u0006\u0010V\u001a\u00020\u001eJ.\u0010x\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001e0y0\u00142\u0006\u0010z\u001a\u00020(2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020|0\u0014J\u0018\u0010}\u001a\u0004\u0018\u00010\u001e2\u0006\u0010z\u001a\u00020(2\u0006\u0010~\u001a\u00020|J2\u0010\u007f\u001a\u00020U2\u0006\u0010z\u001a\u00020(2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020|0\u00142\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u001e2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00140\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010 R\u0019\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010 R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010 R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010 R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010 R\u001d\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010 R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010 R\u001d\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010 R\u001d\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010 R\u001d\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010 R\u001d\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010 R\u001d\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00140\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010 R\u001c\u0010Q\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/anime/oc/characters/avatar/AppSession;", "", "getCatalogueUseCase", "Lcom/anime/oc/characters/avatar/data/usecase/GetCatalogueUseCase;", "appDataManager", "Lcom/anime/oc/characters/avatar/data/datalocal/manager/AppDataManager;", "networkFlow", "Lkotlinx/coroutines/flow/Flow;", "", "context", "Landroid/content/Context;", "(Lcom/anime/oc/characters/avatar/data/usecase/GetCatalogueUseCase;Lcom/anime/oc/characters/avatar/data/datalocal/manager/AppDataManager;Lkotlinx/coroutines/flow/Flow;Landroid/content/Context;)V", "_bgLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_bgStickerFailed", "_bgStickerReady", "_imagesReady", "_isFetchingOnline", "_localDataReady", "_speechCategories", "", "Lcom/anime/oc/characters/avatar/data/model/addcharacter/SpeechCategoryModel;", "_stickerCategories", "Lcom/anime/oc/characters/avatar/data/model/addcharacter/StickerCategoryModel;", "getAppDataManager", "()Lcom/anime/oc/characters/avatar/data/datalocal/manager/AppDataManager;", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "backgroundTexts", "Lkotlinx/coroutines/flow/StateFlow;", "", "getBackgroundTexts", "()Lkotlinx/coroutines/flow/StateFlow;", "backgrounds", "getBackgrounds", "bgStickerFailed", "getBgStickerFailed", "bgStickerReady", "getBgStickerReady", "characters", "Lcom/anime/oc/characters/avatar/data/model/custom/CustomModel;", "getCharacters", "cosplayBitmap", "Landroid/graphics/Bitmap;", "getCosplayBitmap", "()Landroid/graphics/Bitmap;", "setCosplayBitmap", "(Landroid/graphics/Bitmap;)V", "cosplayPercent", "", "getCosplayPercent", "()I", "setCosplayPercent", "(I)V", "customizeBitmap", "getCustomizeBitmap", "setCustomizeBitmap", "customizedCharacters", "getCustomizedCharacters", "error", "getError", "imagesReady", "getImagesReady", "isFetchingOnlineFlow", "isLoading", "localDataReady", "getLocalDataReady", "myDesignPaths", "getMyDesignPaths", "networkOnline", "getNetworkOnline", "speechCategories", "getSpeechCategories", "speechs", "getSpeechs", "stickerCategories", "getStickerCategories", "stickers", "getStickers", "templates", "getTemplates", "userResultBitmap", "getUserResultBitmap", "setUserResultBitmap", "addMyDesign", "", "path", "clearData", "deleteCharacter", "characterId", "fetchOnlineTemplates", "fetchOnlineTemplatesInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceReloadAll", "getCharacterById", "id", "getCharacterByIndex", "index", "getCharacterIndexById", "getTemplateIndexByAvt", "avt", "getTemplateIndexForCustomized", "customizedId", "hasValidSelectionsForCustomized", "isTemplate", "loadBackgroundsAndStickers", "loadBgConfig", "Lcom/anime/oc/characters/avatar/AppSession$BgConfig;", "loadInitialData", "loadUrlList", "baseUrl", "ext", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyImagesReady", "observeNetworkForRetry", "prefetchTemplateImages", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadBackgroundsAndStickers", "refreshApiData", "removeMyDesign", "resolveAllPaths", "Lkotlin/Pair;", "character", "selections", "Lcom/anime/oc/characters/avatar/data/model/custom/SelectionIndex;", "resolvePath", "sel", "saveCharacterWithSelections", "imageSave", "isFlipped", "BgConfig", "CategoryConfig", "Companion", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class AppSession {
    @org.jetbrains.annotations.NotNull()
    private final com.anime.oc.characters.avatar.data.usecase.GetCatalogueUseCase getCatalogueUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager appDataManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> networkFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel>> characters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel>> templates = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel>> customizedCharacters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> backgrounds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> backgroundTexts = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> stickers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> speechs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> myDesignPaths = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _bgStickerFailed = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> bgStickerFailed = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _bgStickerReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> bgStickerReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _bgLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.addcharacter.StickerCategoryModel>> _stickerCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.addcharacter.StickerCategoryModel>> stickerCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.addcharacter.SpeechCategoryModel>> _speechCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.addcharacter.SpeechCategoryModel>> speechCategories = null;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap cosplayBitmap;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap userResultBitmap;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap customizeBitmap;
    private int cosplayPercent = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> networkOnline = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFetchingOnline = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFetchingOnlineFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _imagesReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> imagesReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _localDataReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> localDataReady = null;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String BACKGROUND_BASE_URL = "https://lvtglobal.tech/public/app/ST279_AnimeOCMaker/bg/background";
    @org.jetbrains.annotations.NotNull()
    private static final com.anime.oc.characters.avatar.AppSession.Companion Companion = null;
    
    @javax.inject.Inject()
    public AppSession(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.usecase.GetCatalogueUseCase getCatalogueUseCase, @org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager appDataManager, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<java.lang.Boolean> networkFlow, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager getAppDataManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel>> getCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel>> getTemplates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel>> getCustomizedCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getBackgrounds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getBackgroundTexts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getStickers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getSpeechs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getMyDesignPaths() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getBgStickerFailed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getBgStickerReady() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.addcharacter.StickerCategoryModel>> getStickerCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.anime.oc.characters.avatar.data.model.addcharacter.SpeechCategoryModel>> getSpeechCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getCosplayBitmap() {
        return null;
    }
    
    public final void setCosplayBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getUserResultBitmap() {
        return null;
    }
    
    public final void setUserResultBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getCustomizeBitmap() {
        return null;
    }
    
    public final void setCustomizeBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    public final int getCosplayPercent() {
        return 0;
    }
    
    public final void setCosplayPercent(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNetworkOnline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFetchingOnlineFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getImagesReady() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLocalDataReady() {
        return null;
    }
    
    public final void notifyImagesReady() {
    }
    
    private final java.lang.Object loadUrlList(java.lang.String baseUrl, java.lang.String ext, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.AppSession.BgConfig loadBgConfig() {
        return null;
    }
    
    public final void preloadBackgroundsAndStickers() {
    }
    
    public final void loadBackgroundsAndStickers() {
    }
    
    private final void loadInitialData() {
    }
    
    private final java.lang.Object observeNetworkForRetry(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Gọi từ mọi nơi đều an toàn — guard đảm bảo chỉ 1 request chạy tại 1 thời điểm.
     * BaseActivity gọi khi vào màn + có mạng + chưa có online data.
     */
    private final java.lang.Object fetchOnlineTemplatesInternal(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Public — BaseActivity và pull-to-refresh gọi
     */
    public final void fetchOnlineTemplates() {
    }
    
    public final void forceReloadAll() {
    }
    
    public final void refreshApiData() {
    }
    
    private final java.lang.Object prefetchTemplateImages(java.util.List<com.anime.oc.characters.avatar.data.model.custom.CustomModel> templates, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.anime.oc.characters.avatar.data.model.custom.CustomModel getCharacterByIndex(int index) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.anime.oc.characters.avatar.data.model.custom.CustomModel getCharacterById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public final boolean isTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return false;
    }
    
    public final int getTemplateIndexByAvt(@org.jetbrains.annotations.NotNull()
    java.lang.String avt) {
        return 0;
    }
    
    public final int getCharacterIndexById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return 0;
    }
    
    public final int getTemplateIndexForCustomized(@org.jetbrains.annotations.NotNull()
    java.lang.String customizedId) {
        return 0;
    }
    
    /**
     * Kiểm tra các index đã lưu của character trước khi mở màn hình Edit.
     * Dữ liệu cũ/corrupt có thể chứa colorIndex hoặc pathIndex không còn nằm
     * trong template hiện tại.
     */
    public final boolean hasValidSelectionsForCustomized(@org.jetbrains.annotations.NotNull()
    java.lang.String customizedId) {
        return false;
    }
    
    public final void saveCharacterWithSelections(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.custom.CustomModel character, @org.jetbrains.annotations.NotNull()
    java.util.List<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> selections, @org.jetbrains.annotations.NotNull()
    java.lang.String imageSave, boolean isFlipped) {
    }
    
    public final void deleteCharacter(@org.jetbrains.annotations.NotNull()
    java.lang.String characterId) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String resolvePath(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.custom.CustomModel character, @org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.custom.SelectionIndex sel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.String>> resolveAllPaths(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.model.custom.CustomModel character, @org.jetbrains.annotations.NotNull()
    java.util.List<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> selections) {
        return null;
    }
    
    public final void addMyDesign(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
    }
    
    public final void removeMyDesign(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
    }
    
    public final void clearData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J9\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/anime/oc/characters/avatar/AppSession$BgConfig;", "", "background", "", "Lcom/anime/oc/characters/avatar/AppSession$CategoryConfig;", "sticker", "speechBubble", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBackground", "()Ljava/util/List;", "getSpeechBubble", "getSticker", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    static final class BgConfig {
        @com.google.gson.annotations.SerializedName(value = "background")
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> background = null;
        @com.google.gson.annotations.SerializedName(value = "sticker")
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> sticker = null;
        @com.google.gson.annotations.SerializedName(value = "speech bubble")
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> speechBubble = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.anime.oc.characters.avatar.AppSession.BgConfig copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> background, @org.jetbrains.annotations.NotNull()
        java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> sticker, @org.jetbrains.annotations.NotNull()
        java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> speechBubble) {
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
        
        public BgConfig(@org.jetbrains.annotations.NotNull()
        java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> background, @org.jetbrains.annotations.NotNull()
        java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> sticker, @org.jetbrains.annotations.NotNull()
        java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> speechBubble) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> getBackground() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> getSticker() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.anime.oc.characters.avatar.AppSession.CategoryConfig> getSpeechBubble() {
            return null;
        }
        
        public BgConfig() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/anime/oc/characters/avatar/AppSession$CategoryConfig;", "", "category", "", "quantity", "", "(Ljava/lang/String;I)V", "getCategory", "()Ljava/lang/String;", "getQuantity", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    static final class CategoryConfig {
        @com.google.gson.annotations.SerializedName(value = "category")
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String category = null;
        @com.google.gson.annotations.SerializedName(value = "quantity")
        private final int quantity = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.anime.oc.characters.avatar.AppSession.CategoryConfig copy(@org.jetbrains.annotations.NotNull()
        java.lang.String category, int quantity) {
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
        
        public CategoryConfig(@org.jetbrains.annotations.NotNull()
        java.lang.String category, int quantity) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCategory() {
            return null;
        }
        
        public final int getQuantity() {
            return 0;
        }
        
        public CategoryConfig() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/anime/oc/characters/avatar/AppSession$Companion;", "", "()V", "BACKGROUND_BASE_URL", "", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}