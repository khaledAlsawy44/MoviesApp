package com.moviesapp.network.dataSources

import arrow.core.Either
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieId
import com.moviesApp.business_models.AppErrors

interface MoviesDetailsDataSource {
    suspend fun getMovieDetails(movieId: MovieId): Either<AppErrors, MovieDetails>
}