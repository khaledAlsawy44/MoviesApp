package com.moviesApp.navigation

import androidx.navigation.NamedNavArgument
import com.moviesApp.navigation.navArgs.movieDetailsNavArgs


sealed class NavigationScreens {
    abstract val arguments: List<NamedNavArgument>
    abstract val destination: String
    abstract val route: String

    data class MoviesList(
        override val arguments: List<NamedNavArgument> = emptyList(),
        override val destination: String = "MoviesList",
        override val route: String = "MoviesList"
    ) : NavigationScreens()

    data class MovieDetails(
        override val arguments: List<NamedNavArgument> = movieDetailsNavArgs(),
        override val destination: String = "MovieDetails",
        override val route: String = "MovieDetails/{${NavigationArgumentsConstants.MOVIE_ID}}"
    ) : NavigationScreens()

}







