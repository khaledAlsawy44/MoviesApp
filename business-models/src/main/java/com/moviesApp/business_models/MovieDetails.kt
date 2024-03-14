package com.moviesApp.business_models

@JvmInline
value class MovieStatus(val value: String)

@JvmInline
value class MovieGenres(val value: String)

@JvmInline
value class ProductionCompaniesLogo(val value: String)

@JvmInline
value class ProductionCompaniesName(val value: String)

data class ProductionCompanies(
    val logoPath: ProductionCompaniesLogo,
    val name: ProductionCompaniesName
)

data class MovieDetails(
    val id: MovieId,
    val title: MovieTitle,
    val posterUrl: MoviePosterUrl,
    val overview: MovieOverview,
    val rate: MovieRate,
    val rateCount: MovieRateCount,
    val status: MovieStatus,
    val genres: List<MovieGenres>,
    val productionCompanies: List<ProductionCompanies>
)
