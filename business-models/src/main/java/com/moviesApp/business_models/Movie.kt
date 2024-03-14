package com.moviesApp.business_models

@JvmInline
value class MovieId(val value: Int)

@JvmInline
value class MovieTitle(val value: String)

@JvmInline
value class MoviePosterUrl(val value: String)

@JvmInline
value class MovieOverview(val value: String)

@JvmInline
value class MovieRate(val value: Double)

@JvmInline
value class MovieRateCount(val value: Int)
data class Movie(
    val id: MovieId,
    val title: MovieTitle,
    val posterUrl: MoviePosterUrl,
    val overview: MovieOverview,
    val movieRate: MovieRate,
    val rateCount: MovieRateCount
)
