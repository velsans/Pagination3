package com.vel.saveo.ui.main.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        // Base url of the api
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        // create retrofit service
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}