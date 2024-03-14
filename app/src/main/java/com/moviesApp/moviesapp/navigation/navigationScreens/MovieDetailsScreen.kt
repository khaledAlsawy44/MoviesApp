package com.moviesApp.moviesapp.navigation.navigationScreens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.moviesApp.navigation.NavigationScreens

fun NavGraphBuilder.movieDetailsScreen(
    navController: NavHostController
) {
    composable(
        route = NavigationScreens.MovieDetails().route,
        arguments = NavigationScreens.MovieDetails().arguments
    ) {
    }
}