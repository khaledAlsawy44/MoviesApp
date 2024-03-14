package com.moviesapp.network.entities

import kotlinx.serialization.Serializable

@Serializable
data class PaginationResponse<T>(
    val page: Int? = null,
    val results: List<T>? = null,
    val totalPages: Int? = null,
    val totalResults: Int? = null
)