package com.moviesApp.moviesapp.navigation.navigationScreens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.moviesApp.business_models.MovieId
import com.moviesApp.common.base.BaseComposeScreen
import com.moviesApp.movieslist.MoviesListActions
import com.moviesApp.movieslist.MoviesListScreenContent
import com.moviesApp.movieslist.MoviesListState
import com.moviesApp.movieslist.MoviesListViewModel
import com.moviesApp.navigation.NavigationScreens

fun NavGraphBuilder.moviesListScreen(
    navigateToMovieDetails: (MovieId) -> Unit
) {
    composable(NavigationScreens.MoviesList().route) {
        BaseComposeScreen<MoviesListState, MoviesListActions, Any, MoviesListViewModel> { state, onAction ->
            MoviesListScreenContent(state = state) { action ->
                onAction.invoke(action)
                if (action is MoviesListActions.OnMoveClicked) navigateToMovieDetails.invoke(action.id)
            }
        }
    }
}