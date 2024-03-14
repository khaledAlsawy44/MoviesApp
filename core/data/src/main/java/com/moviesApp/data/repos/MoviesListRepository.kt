package com.moviesApp.data.repos

import arrow.core.Either
import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData

interface MoviesListRepository {
    suspend fun getMoviesList(page: CurrentPage): Either<AppErrors, PaginatedData<Movie>>
}