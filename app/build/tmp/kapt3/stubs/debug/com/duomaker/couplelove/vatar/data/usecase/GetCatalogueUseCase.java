package com.duomaker.couplelove.vatar.data.usecase;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0086B\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0014"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/usecase/GetCatalogueUseCase;", "", "remoteDataSource", "Lcom/duomaker/couplelove/vatar/data/datalocal/api/RemoteDataSource;", "appDataManager", "Lcom/duomaker/couplelove/vatar/data/datalocal/manager/AppDataManager;", "context", "Landroid/content/Context;", "(Lcom/duomaker/couplelove/vatar/data/datalocal/api/RemoteDataSource;Lcom/duomaker/couplelove/vatar/data/datalocal/manager/AppDataManager;Landroid/content/Context;)V", "invoke", "Lkotlin/Result;", "", "Lcom/duomaker/couplelove/vatar/data/model/custom/CustomModel;", "invoke-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadAvatarsParallel", "", "templates", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class GetCatalogueUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.duomaker.couplelove.vatar.data.datalocal.api.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager appDataManager = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "GetCatalogueUseCase";
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.data.usecase.GetCatalogueUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public GetCatalogueUseCase(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.datalocal.api.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager appDataManager, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Preload tất cả avatar song song (coroutineScope + async).
     * Hàm này SUSPEND — caller phải chờ cho đến khi tất cả avatar được cache.
     * → Đảm bảo khi SplashActivity navigate sang ChoosePony, ảnh đã sẵn sàng.
     */
    private final java.lang.Object preloadAvatarsParallel(java.util.List<com.duomaker.couplelove.vatar.data.model.custom.CustomModel> templates, kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/usecase/GetCatalogueUseCase$Companion;", "", "()V", "TAG", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}