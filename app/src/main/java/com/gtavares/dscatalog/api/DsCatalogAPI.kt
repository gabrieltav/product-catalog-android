package com.gtavares.dscatalog.api

import com.gtavares.dscatalog.model.PageResponse
import com.gtavares.dscatalog.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface DsCatalogAPI {
    @GET("products")
    suspend fun recoverProducts(): Response<PageResponse<Product>>
}