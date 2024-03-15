package com.moviesapp.network.entities

import com.moviesapp.network.di.ServerLocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class MovieResponse(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val genre_ids: List<Int?>? = null,
    val id: Int? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    @Serializable(with = ServerLocalDateTimeSerializer::class)
    val release_date: LocalDate? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)
