package com.moviesApp.movieDetails

import androidx.compose.runtime.Composable
import com.moviesApp.common.compose.RenderErrorState
import com.moviesApp.common.compose.RenderLoadingState
import com.moviesApp.movieDetails.compose.RenderState

@Composable
fun MovieDetailsScreenContent(
    onBackClicked: () -> Unit,
    state: MovieDetailsState
) {
    when (state) {
        is MovieDetailsState.Error -> RenderErrorState(errorMessage = state.error)
        MovieDetailsState.Loading -> RenderLoadingState()
        is MovieDetailsState.Success -> state.RenderState(onBackClicked)
    }
}


