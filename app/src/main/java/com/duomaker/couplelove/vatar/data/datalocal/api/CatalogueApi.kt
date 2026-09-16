package com.duomaker.couplelove.vatar.data.datalocal.api

import com.duomaker.couplelove.vatar.data.model.api.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface CatalogueApi {
    @GET("api/ST183_PrincessAvatarMaker")
    suspend fun getData(): Response<CharacterResponse>
}