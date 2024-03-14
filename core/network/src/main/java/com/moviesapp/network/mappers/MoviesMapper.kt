package com.moviesapp.network.mappers

import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieGenres
import com.moviesApp.business_models.MovieId
import com.moviesApp.business_models.MovieOverview
import com.moviesApp.business_models.MoviePosterUrl
import com.moviesApp.business_models.MovieRate
import com.moviesApp.business_models.MovieRateCount
import com.moviesApp.business_models.MovieStatus
import com.moviesApp.business_models.MovieTitle
import com.moviesApp.business_models.ProductionCompanies
import com.moviesApp.business_models.ProductionCompaniesLogo
import com.moviesApp.business_models.ProductionCompaniesName
import com.moviesapp.network.BuildConfig.IMAGES_BASE_URL
import com.moviesapp.network.entities.MovieDetailsResponse
import com.moviesapp.network.entities.MovieResponse


fun MovieResponse.toMovie(): Movie? {
    title ?: return null
    overview ?: return null
    vote_average ?: return null
    poster_path ?: return null
    vote_count ?: return null
    id ?: return null

    return Movie(
        id = MovieId(id),
        title = MovieTitle(title),
        posterUrl = MoviePosterUrl("$IMAGES_BASE_URL$poster_path"),
        overview = MovieOverview(overview),
        movieRate = MovieRate(vote_average),
        rateCount = MovieRateCount(vote_count)
    )
}

fun MovieDetailsResponse.toMovieDetails(): MovieDetails? {
    id ?: return null
    title ?: return null
    overview ?: return null
    vote_average ?: return null
    poster_path ?: return null
    vote_count ?: return null
    status ?: return null
    genres ?: return null
    production_companies ?: return null

    return MovieDetails(
        id = MovieId(id),
        title = MovieTitle(title),
        posterUrl = MoviePosterUrl("$IMAGES_BASE_URL$poster_path"),
        overview = MovieOverview(overview),
        rate = MovieRate(vote_average),
        rateCount = MovieRateCount(vote_count),
        status = MovieStatus(status),
        genres = genres.mapNotNull { it.toMovieGenres() },
        productionCompanies = production_companies.mapNotNull { it.validateCompanies() }
    )


}


fun MovieDetailsResponse.Genre?.toMovieGenres(): MovieGenres? {
    val genreName = this?.name?.takeIf { it.isBlank().not() }
    return genreName?.let { MovieGenres(it) }
}

fun MovieDetailsResponse.ProductionCompany?.validateCompanies(): ProductionCompanies? {
    val name = this?.name
    val logo = this?.logo_path
    return if (name.isNullOrBlank() || logo.isNullOrBlank()) null
    else ProductionCompanies(
        name = ProductionCompaniesName(name),
        logoPath = ProductionCompaniesLogo(logo)
    )
}

