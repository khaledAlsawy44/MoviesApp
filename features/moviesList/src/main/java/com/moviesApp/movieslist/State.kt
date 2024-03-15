package com.moviesApp.movieslist

import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.MovieId
import com.moviesApp.business_models.PaginatedData

sealed class MoviesListState {
    data object Loading : MoviesListState()
    data object Empty : MoviesListState()
    data class Success(
        val movies: PaginatedData<Movie>,
        val searchQuery: String = ""
    ) : MoviesListState()

    data class Error(val error: AppErrors) : MoviesListState()
}

sealed class MoviesListActions {
    data object OnLoadMore : MoviesListActions()
    data class OnSearch(val searchQuery: String) : MoviesListActions()
    data class OnMoveClicked(val id: MovieId) : MoviesListActions()
}