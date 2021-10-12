package com.vel.saveo.ui.main.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Velmurugan on 9/24/2021.
 */
class RetroInstance {
    companion object {
        // Base url of the api
        val BASE_URL = "https://rickandmortyapi.com/api/"

        // create retrofit service
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}