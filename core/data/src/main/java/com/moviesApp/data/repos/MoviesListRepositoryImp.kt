package com.moviesApp.data.repos

import arrow.core.Either
import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData
import com.moviesapp.network.dataSources.MoviesListDataSource
import javax.inject.Inject

class MoviesListRepositoryImp @Inject constructor(
    private val remoteDataSource: MoviesListDataSource
) : MoviesListRepository {

    override suspend fun getMoviesList(page: CurrentPage): Either<AppErrors, PaginatedData<Movie>> {
        return remoteDataSource.getMoviesList(page)
    }

    override suspend fun searchMoviesList(
        page: CurrentPage,
        searchQuery: String
    ): Either<AppErrors, PaginatedData<Movie>> {
        return remoteDataSource.searchMoviesList(page, searchQuery)
    }

}
