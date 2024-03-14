package com.moviesApp.data.repos

import arrow.core.Either
import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieId

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: MovieId): Either<AppErrors, MovieDetails>
}