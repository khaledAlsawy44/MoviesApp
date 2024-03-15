package com.moviesapp.network.dataSources

import arrow.core.Either
import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData

interface MoviesListDataSource {
    suspend fun getMoviesList(page: CurrentPage): Either<AppErrors, PaginatedData<Movie>>
    suspend fun searchMoviesList(
        page: CurrentPage,
        searchQuery: String
    ): Either<AppErrors, PaginatedData<Movie>>
}