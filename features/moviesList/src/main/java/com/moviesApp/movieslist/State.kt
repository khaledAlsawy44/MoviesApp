package com.moviesApp.movieslist

import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData

sealed class MoviesListState {
    data object Loading : MoviesListState()
    data class Success(
        val movies: PaginatedData<Movie>
    ) : MoviesListState()

    data class Error(val error: AppErrors) : MoviesListState()
}