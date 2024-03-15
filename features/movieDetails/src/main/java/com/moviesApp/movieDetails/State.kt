package com.moviesApp.movieDetails

import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.MovieDetails

sealed class MovieDetailsState {
    data object Loading : MovieDetailsState()
    data class Success(val movieDetails: MovieDetails) : MovieDetailsState()
    data class Error(val error: AppErrors) : MovieDetailsState()
}