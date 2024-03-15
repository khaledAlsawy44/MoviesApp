package com.moviesApp.movieDetails

import androidx.lifecycle.SavedStateHandle
import com.moviesApp.business_models.AppErrors
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieId
import com.moviesApp.common.base.StateViewModel
import com.moviesApp.data.repos.MovieDetailsRepository
import com.moviesApp.navigation.NavigationArgumentsConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repo: MovieDetailsRepository,
    private val savedStateHandle: SavedStateHandle
) : StateViewModel<MovieDetailsState, Any, Any>() {

    init {
        fetchMovieDetails()
    }


    override fun onAction(action: Any) {}

    private fun fetchMovieDetails() {
        val movieId = savedStateHandle.get<Int>(NavigationArgumentsConstants.MOVIE_ID) ?: return
        launch {
            callApi(
                block = { repo.getMovieDetails(MovieId(movieId)) },
                mapErrorResult = ::onApiError,
                mapSuccessResult = ::onSuccess
            )
        }
    }

    private fun onApiError(appErrors: AppErrors) {
        setState(MovieDetailsState.Error(appErrors))
    }

    private fun onSuccess(result: MovieDetails) {
        setState(MovieDetailsState.Success(result))
    }

}
