package com.gtavares.dscatalog.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imgUrl: String,
    val date: String,
    val categories: List<Category>
)

data class Category(
    val id: Int,
    val name: String
)

data class PageResponse<T>(
    val content: List<Product>,
    val pageable: Pageable,
    val totalPages: Int,
    val totalElements: Int,
    val last: Boolean,
    val size: Int,
    val number: Int,
    val sort: Sort,
    val numberOfElements: Int,
    val first: Boolean,
    val empty: Boolean
)

data class Pageable(
    val sort: Sort,
    val offset: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
    val unpaged: Boolean
)

data class Sort(
    val sorted: Boolean,
    val unsorted: Boolean,
    val empty: Boolean
)
