package com.moviesApp.movieslist

import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData
import com.moviesApp.common.base.StateViewModel
import com.moviesApp.data.repos.MoviesListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val repo: MoviesListRepository
) : StateViewModel<MoviesListState, MoviesListActions, Any>() {


    init {
        fetchFirstMoviesPage()
    }

    override fun onAction(action: MoviesListActions) {
        when (action) {
            is MoviesListActions.OnLoadMore -> onLoadMore()
            is MoviesListActions.OnMoveClicked -> {}
        }
    }

    private fun fetchFirstMoviesPage() {
        launch {
            callApi(
                block = { repo.getMoviesList(CurrentPage(1)) },
                mapErrorResult = ::onApiError,
                mapSuccessResult = ::onFirstPageSuccess
            )
        }
    }

    private fun onLoadMore() {
        val currentState = currentStateIfSuccess() ?: return
        val currentPage = currentState.movies.page.value
        val nextPage = CurrentPage(currentPage.plus(1))
        launch {
            callApi(
                block = { repo.getMoviesList(page = nextPage) },
                mapErrorResult = {},
                mapSuccessResult = ::onLoadMoreSuccess
            )
        }
    }

    private fun onFirstPageSuccess(result: PaginatedData<Movie>) {
        setState(MoviesListState.Success(result))
    }

    private fun onLoadMoreSuccess(result: PaginatedData<Movie>) {
        val currentState = currentStateIfSuccess() ?: return
        val currentMoviesList = currentState.movies.list
        val newMoviesList = result.list

        setState(
            currentState.copy(
                movies = result.copy(list = currentMoviesList.plus(newMoviesList))
            )
        )
    }

    private fun onApiError(appErrors: AppErrors) {
        setState(MoviesListState.Error(appErrors))
    }


    private fun currentStateIfSuccess(): MoviesListState.Success? {
        val currentState = currentState()
        return if (currentState is MoviesListState.Success) currentState
        else null
    }
}
