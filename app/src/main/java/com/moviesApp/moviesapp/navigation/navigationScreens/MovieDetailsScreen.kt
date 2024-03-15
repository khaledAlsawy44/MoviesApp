package com.moviesApp.moviesapp.navigation.navigationScreens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.moviesApp.common.base.BaseComposeScreen
import com.moviesApp.movieDetails.MovieDetailsScreenContent
import com.moviesApp.movieDetails.MovieDetailsState
import com.moviesApp.movieDetails.MovieDetailsViewModel
import com.moviesApp.navigation.NavigationScreens

fun NavGraphBuilder.movieDetailsScreen(
    navController: NavHostController
) {
    composable(
        route = NavigationScreens.MovieDetails().route,
        arguments = NavigationScreens.MovieDetails().arguments
    ) {
        BaseComposeScreen<MovieDetailsState, Any, Any, MovieDetailsViewModel> { state, _ ->
            MovieDetailsScreenContent(
                state = state,
                onBackClicked = { navController.navigateUp() }
            )
        }
    }
}