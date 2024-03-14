package com.moviesApp.moviesapp.navigation.navigationScreens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.moviesApp.common.base.BaseComposeScreen
import com.moviesApp.movieslist.MoviesListScreenContent
import com.moviesApp.movieslist.MoviesListState
import com.moviesApp.movieslist.MoviesListViewModel
import com.moviesApp.navigation.NavigationScreens

fun NavGraphBuilder.moviesListScreen(
    navController: NavHostController
) {
    composable(NavigationScreens.MoviesList().route) {
        BaseComposeScreen<MoviesListState, Any, Any, MoviesListViewModel> {
            MoviesListScreenContent(state = it)
        }
    }
}