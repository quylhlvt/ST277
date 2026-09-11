package com.anime.oc.characters.avatar.data.repository;

/**
 * Repository chịu trách nhiệm gọi API liên quan đến CustomModel (characters)
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/anime/oc/characters/avatar/data/repository/ApiRepository;", "", "catalogueApi", "Lcom/anime/oc/characters/avatar/data/datalocal/api/CatalogueApi;", "(Lcom/anime/oc/characters/avatar/data/datalocal/api/CatalogueApi;)V", "getCatalogue", "Lretrofit2/Response;", "", "", "", "Lcom/anime/oc/characters/avatar/data/model/api/PartAPI;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class ApiRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.anime.oc.characters.avatar.data.datalocal.api.CatalogueApi catalogueApi = null;
    
    @javax.inject.Inject()
    public ApiRepository(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.datalocal.api.CatalogueApi catalogueApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCatalogue(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.util.List<com.anime.oc.characters.avatar.data.model.api.PartAPI>>>> $completion) {
        return null;
    }
}