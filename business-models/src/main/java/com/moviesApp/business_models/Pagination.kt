package com.moviesApp.business_models


@JvmInline
value class CurrentPage(val value: Int)

@JvmInline
value class TotalPages(val value: Int)

data class PaginatedData<T>(
    val page: CurrentPage,
    val totalPages: TotalPages,
    val list: List<T>
)
