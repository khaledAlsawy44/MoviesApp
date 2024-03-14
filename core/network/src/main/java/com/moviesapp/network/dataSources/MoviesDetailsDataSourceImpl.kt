package com.moviesapp.network.dataSources

import arrow.core.Either
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieId
import com.moviesapp.network.apiIHandler.mapResponseData
import com.moviesapp.network.apiIHandler.safeApiCall
import com.moviesApp.business_models.AppErrors
import com.moviesapp.network.mappers.toMovieDetails
import com.moviesapp.network.services.MoviesService
import javax.inject.Inject

class MoviesDetailsDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : MoviesDetailsDataSource {
    override suspend fun getMovieDetails(movieId: MovieId): Either<AppErrors, MovieDetails> {
        return safeApiCall {
            moviesService.fetchMovieById(movieId.value).mapResponseData { detailsResponse ->
                detailsResponse.toMovieDetails()
            }
        }
    }
}