package com.vel.saveo.ui.main.api

import com.vel.saveo.ui.main.model.RespoceModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query: Int): RespoceModelList
}