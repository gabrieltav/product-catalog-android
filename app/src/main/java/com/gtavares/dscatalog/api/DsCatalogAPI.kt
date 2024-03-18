package com.gtavares.dscatalog.api

import com.gtavares.dscatalog.model.PageResponse
import com.gtavares.dscatalog.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DsCatalogAPI {
    @GET("products?page=&size=&sort=name,asc&categoryId=&name=")
    suspend fun recoverProducts(): Response<PageResponse<Product>>

    @GET("products")
    suspend fun recoverProductsByName(
        @Query("name") productName: String?
    ): Response<PageResponse<Product>>
}