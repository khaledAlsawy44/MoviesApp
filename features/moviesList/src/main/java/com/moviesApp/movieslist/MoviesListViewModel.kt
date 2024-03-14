package com.moviesApp.movieslist

import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData
import com.moviesApp.common.base.StateViewModel
import com.moviesApp.data.repos.MoviesListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val repo: MoviesListRepository
) : StateViewModel<MoviesListState, Any, Any>() {


    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        launch {
            callApi(
                block = { repo.getMoviesList(CurrentPage(1)) },
                mapErrorResult = ::onGetMoviesListError,
                mapSuccessResult = ::onGetMoviesListSuccess
            )
        }
    }

    private fun onGetMoviesListError(appErrors: AppErrors) {
        setState(MoviesListState.Error(appErrors))
    }

    private fun onGetMoviesListSuccess(result: PaginatedData<Movie>) {
        setState(MoviesListState.Success(result))
    }
}
