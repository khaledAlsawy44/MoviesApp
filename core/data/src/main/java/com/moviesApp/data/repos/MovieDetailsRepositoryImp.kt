package com.moviesApp.data.repos

import arrow.core.Either
import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieId
import com.moviesapp.network.dataSources.MoviesDetailsDataSource
import javax.inject.Inject

class MovieDetailsRepositoryImp @Inject constructor(
    private val remoteDataSource: MoviesDetailsDataSource
) : MovieDetailsRepository {
    override suspend fun getMovieDetails(movieId: MovieId): Either<AppErrors, MovieDetails> {
        return remoteDataSource.getMovieDetails(movieId)
    }
}
