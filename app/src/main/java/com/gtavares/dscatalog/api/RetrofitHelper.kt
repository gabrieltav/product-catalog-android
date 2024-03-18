package com.gtavares.dscatalog.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun recoverData(): DsCatalogAPI {
        return Retrofit.Builder()
            .baseUrl("https://bds-dscatalog.onrender.com/")
//            .baseUrl("http://192.168.15.10:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DsCatalogAPI::class.java)
    }
}