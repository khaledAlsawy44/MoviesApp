package com.moviesapp.network.entities

import kotlinx.serialization.Serializable

@Serializable
data class PaginationResponse<T>(
    val page: Int? = null,
    val results: List<T>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)