package com.moviesapp.network.dataSources

import arrow.core.Either
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData
import com.moviesapp.network.entities.AppErrors

interface MoviesListDataSource {
    suspend fun getMoviesList(page: CurrentPage): Either<AppErrors, PaginatedData<Movie>>
}