package com.moviesApp.business_models

import java.time.LocalDate

@JvmInline
value class MovieId(val value: Int)

@JvmInline
value class MovieTitle(val value: String)

@JvmInline
value class MoviePosterUrl(val value: String)

@JvmInline
value class BackdropUrl(val value: String)

@JvmInline
value class MovieOverview(val value: String)

@JvmInline
value class MovieRate(val value: Double)

@JvmInline
value class MovieRateCount(val value: Int)

@JvmInline
value class MovieReleaseDate(val value: LocalDate)
data class Movie(
    val id: MovieId,
    val title: MovieTitle,
    val posterUrl: MoviePosterUrl,
    val overview: MovieOverview,
    val movieRate: MovieRate,
    val rateCount: MovieRateCount,
    val releaseDate: MovieReleaseDate?
)
