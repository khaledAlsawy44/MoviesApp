package com.moviesApp.moviesapp.navigation.navGraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.moviesApp.moviesapp.navigation.navigationScreens.movieDetailsScreen
import com.moviesApp.moviesapp.navigation.navigationScreens.moviesListScreen
import com.moviesApp.navigation.NavigationScreens


@Composable
fun AppNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.Root,
        startDestination = NavigationScreens.MoviesList().destination
    ) {
        moviesListScreen({})
        movieDetailsScreen(navController)
    }
}

object Graph {
    const val Root = "root_graph"
}