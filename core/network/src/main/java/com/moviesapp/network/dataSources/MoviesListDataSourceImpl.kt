package com.moviesapp.network.dataSources

import arrow.core.Either
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData
import com.moviesapp.network.apiIHandler.mapPaginatedResponseData
import com.moviesapp.network.apiIHandler.safeApiCall
import com.moviesApp.business_models.AppErrors
import com.moviesapp.network.mappers.toMovie
import com.moviesapp.network.services.MoviesService
import javax.inject.Inject

class MoviesListDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : MoviesListDataSource {
    override suspend fun getMoviesList(page: CurrentPage): Either<AppErrors, PaginatedData<Movie>> {

        return safeApiCall {
            moviesService.fetchMoviesList(page.value).mapPaginatedResponseData {
                it.toMovie()
            }
        }
    }
}
