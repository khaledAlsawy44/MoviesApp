package com.moviesApp.navigation.navArgs

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.moviesApp.navigation.NavigationArgumentsConstants

fun movieDetailsNavArgs() = listOf(
    navArgument(NavigationArgumentsConstants.MOVIE_ID) {
        type = NavType.IntType
    }
)