package com.duomaker.couplelove.vatar.data.datalocal.manager;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 }2\u00020\u0001:\u0001}B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010;J\u0016\u0010<\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0007H\u0002J\u0006\u0010?\u001a\u000209J\b\u0010@\u001a\u000209H\u0002J\u0016\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010;J\u000e\u0010C\u001a\u000209H\u0086@\u00a2\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u0004\u0018\u00010\u000b2\u0006\u0010F\u001a\u00020\bJ\u0010\u0010G\u001a\u0004\u0018\u00010\u000b2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u0004\u0018\u00010\u000b2\u0006\u0010F\u001a\u00020\bJ\u0010\u0010K\u001a\u0004\u0018\u00010\u000b2\u0006\u0010H\u001a\u00020IJ\u000e\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\bJ\u000e\u0010N\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\bJ\u000e\u0010O\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010P\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010Q\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010R\u001a\u000209H\u0086@\u00a2\u0006\u0002\u0010DJ\u000e\u0010S\u001a\u000209H\u0086@\u00a2\u0006\u0002\u0010DJ\u000e\u0010T\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010U\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010DJ\u000e\u0010V\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010W\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010X\u001a\u000209H\u0082@\u00a2\u0006\u0002\u0010DJ\u000e\u0010Y\u001a\u000209H\u0086@\u00a2\u0006\u0002\u0010DJ\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0082@\u00a2\u0006\u0002\u0010DJ\u001c\u0010[\u001a\u00020I2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086@\u00a2\u0006\u0002\u0010]J\u0014\u0010^\u001a\u0002092\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\u000e\u0010_\u001a\u000209H\u0086@\u00a2\u0006\u0002\u0010DJ\u0016\u0010`\u001a\u0002092\u0006\u0010:\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010;J.\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\b0b0\u00072\u0006\u0010c\u001a\u00020\u000b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u0007J\u0018\u0010f\u001a\u0004\u0018\u00010\b2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020eJ*\u0010h\u001a\b\u0012\u0004\u0012\u00020I0i2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bj\u0010]J*\u0010k\u001a\b\u0012\u0004\u0012\u00020I0i2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bl\u0010]J*\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00100i2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bo\u0010]J)\u0010p\u001a\b\u0012\u0004\u0012\u0002090i2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bq\u0010rJ\"\u0010s\u001a\u0002092\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J0\u0010u\u001a\u0002092\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010w\u001a\u0002092\u0006\u0010c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010xJ$\u0010y\u001a\u0004\u0018\u0001Hz\"\u0006\b\u0000\u0010z\u0018\u0001*\u00020%2\u0006\u0010{\u001a\u00020\bH\u0082\b\u00a2\u0006\u0002\u0010|R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0019R\u001d\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0019R\u001d\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0019\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006~"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/datalocal/manager/AppDataManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_backgroundTexts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "_backgrounds", "_characters", "Lcom/duomaker/couplelove/vatar/data/model/custom/CustomModel;", "_customizedCharacters", "_error", "_errorQuick", "_isLoading", "", "_isQuickLoading", "_myDesignPaths", "_speechs", "_stickers", "_templates", "backgroundTexts", "Lkotlinx/coroutines/flow/StateFlow;", "getBackgroundTexts", "()Lkotlinx/coroutines/flow/StateFlow;", "backgrounds", "getBackgrounds", "characters", "getCharacters", "customizedCharacters", "getCustomizedCharacters", "error", "getError", "errorQuick", "getErrorQuick", "gson", "Lcom/google/gson/Gson;", "isDataLoaded", "isDataQuickLoaded", "isLoading", "isQuickLoading", "mmkv", "Lcom/tencent/mmkv/MMKV;", "getMmkv", "()Lcom/tencent/mmkv/MMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "myDesignPaths", "getMyDesignPaths", "speechs", "getSpeechs", "stickers", "getStickers", "templates", "getTemplates", "addMyDesignPath", "", "imagePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applySpecialPrefixes", "bodyParts", "Lcom/duomaker/couplelove/vatar/data/model/custom/BodyPartModel;", "clearData", "combineCharacterLists", "deleteCustomizedCharacter", "characterId", "forceReloadAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCharacterById", "id", "getCharacterByIndex", "index", "", "getTemplateById", "getTemplateByIndex", "getTemplateIndexByAvt", "avt", "isTemplate", "loadBackgroundTexts", "loadBackgrounds", "loadCustomizedCharacters", "loadInitialData", "loadMyDesignData", "loadMyDesigns", "loadQuickData", "loadSpeechs", "loadStickers", "loadTemplates", "loadTemplatesFromAssets", "loadTemplatesFromJson", "mergeApiTemplates", "onlineTemplates", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prependOnlineTemplates", "refreshFromApi", "removeMyDesignPath", "resolveAllPaths", "Lkotlin/Pair;", "character", "selections", "Lcom/duomaker/couplelove/vatar/data/model/custom/SelectionIndex;", "resolvePathFromSelection", "sel", "saveApiCache", "Lkotlin/Result;", "saveApiCache-gIAlu-s", "saveCustomizedCharacters", "saveCustomizedCharacters-gIAlu-s", "saveMyDesignToJson", "paths", "saveMyDesignToJson-gIAlu-s", "saveTemplatesToJson", "saveTemplatesToJson-IoAF18A", "(Ljava/util/List;)Ljava/lang/Object;", "updateBackgroundsAndStickers", "bgs", "updateBackgroundsStickersAndSpeech", "speech", "updateCustomizedCharacter", "(Lcom/duomaker/couplelove/vatar/data/model/custom/CustomModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeFromJson", "T", "json", "(Lcom/google/gson/Gson;Ljava/lang/String;)Ljava/lang/Object;", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class AppDataManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AppDataManager";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TEMPLATES_FILE = "templates.json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CUSTOMIZED_FILE = "customized.json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String MY_DESIGNS_FILE = "my_designs.json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_CACHE_FILE = "api_cache.json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TEMPLATES = "templates";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CUSTOMIZED = "customized";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_MY_DESIGNS = "my_designs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_API_CACHE = "api_cache";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mmkv$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> _templates = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> templates = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> _customizedCharacters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> customizedCharacters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> _characters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> characters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _backgrounds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> backgrounds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _backgroundTexts = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> backgroundTexts = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _stickers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> stickers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _speechs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> speechs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _myDesignPaths = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> myDesignPaths = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isQuickLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isQuickLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorQuick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorQuick = null;
    private boolean isDataLoaded = false;
    private boolean isDataQuickLoaded = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public AppDataManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final com.tencent.mmkv.MMKV getMmkv() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> getTemplates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> getCustomizedCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> getCharacters() {
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
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isQuickLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorQuick() {
        return null;
    }
    
    public final void updateBackgroundsAndStickers(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> bgs, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> stickers) {
    }
    
    public final void updateBackgroundsStickersAndSpeech(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> bgs, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> stickers, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> speech) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loadInitialData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loadQuickData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Merge API templates vào _templates:
     * - Giữ nguyên local templates (template_*)
     * - Thay thế/thêm online templates (online_*)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object mergeApiTemplates(@org.jetbrains.annotations.NotNull()
    java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel> onlineTemplates, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final java.lang.Object loadTemplates(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loadTemplatesFromAssets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void applySpecialPrefixes(java.util.List<com.duomaker.couplelove.vatar.data.model.custom.BodyPartModel> bodyParts) {
    }
    
    private final java.lang.Object loadTemplatesFromJson(kotlin.coroutines.Continuation<? super java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel>> $completion) {
        return null;
    }
    
    private final java.lang.Object loadCustomizedCharacters(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateCustomizedCharacter(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.custom.CustomModel character, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteCustomizedCharacter(@org.jetbrains.annotations.NotNull()
    java.lang.String characterId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void combineCharacterLists() {
    }
    
    public final void prependOnlineTemplates(@org.jetbrains.annotations.NotNull()
    java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel> onlineTemplates) {
    }
    
    public final boolean isTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.duomaker.couplelove.vatar.data.model.custom.CustomModel getCharacterByIndex(int index) {
        return null;
    }
    
    /**
     * Resolve an index that was created from [templates]. Do not use
     * getCharacterByIndex() here: that list also contains saved characters.
     */
    @org.jetbrains.annotations.Nullable()
    public final com.duomaker.couplelove.vatar.data.model.custom.CustomModel getTemplateByIndex(int index) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.duomaker.couplelove.vatar.data.model.custom.CustomModel getTemplateById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.duomaker.couplelove.vatar.data.model.custom.CustomModel getCharacterById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public final int getTemplateIndexByAvt(@org.jetbrains.annotations.NotNull()
    java.lang.String avt) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String resolvePathFromSelection(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.custom.CustomModel character, @org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex sel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.String>> resolveAllPaths(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.model.custom.CustomModel character, @org.jetbrains.annotations.NotNull()
    java.util.List<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> selections) {
        return null;
    }
    
    private final java.lang.Object loadBackgrounds(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadBackgroundTexts(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadStickers(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadSpeechs(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadMyDesigns(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addMyDesignPath(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeMyDesignPath(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loadMyDesignData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshFromApi(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object forceReloadAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void clearData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/datalocal/manager/AppDataManager$Companion;", "", "()V", "API_CACHE_FILE", "", "ASSET_PREFIX", "CUSTOMIZED_FILE", "KEY_API_CACHE", "KEY_CUSTOMIZED", "KEY_MY_DESIGNS", "KEY_TEMPLATES", "MY_DESIGNS_FILE", "TAG", "TEMPLATES_FILE", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}