package com.gtavares.dscatalog.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun recoverData(): DsCatalogAPI {
        return Retrofit.Builder()
            .baseUrl("https://bds-dscatalog.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DsCatalogAPI::class.java)
    }
}