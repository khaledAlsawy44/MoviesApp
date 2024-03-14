package com.moviesApp.moviesapp.navigation.navigationScreens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.moviesApp.navigation.NavigationScreens

fun NavGraphBuilder.moviesListScreen(
    navController: NavHostController
) {
    composable(NavigationScreens.MoviesList().route) {

    }
}