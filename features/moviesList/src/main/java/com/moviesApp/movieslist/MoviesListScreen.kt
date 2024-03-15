package com.moviesApp.movieslist

import androidx.compose.runtime.Composable
import com.moviesApp.common.compose.RenderErrorState
import com.moviesApp.common.compose.RenderLoadingState
import com.moviesApp.movieslist.compose.RenderState


@Composable
fun MoviesListScreenContent(
    state: MoviesListState,
    onAction : (MoviesListActions)-> Unit
) {
    when (state) {
        is MoviesListState.Error -> RenderErrorState(errorMessage = state.error)
        MoviesListState.Loading -> RenderLoadingState()
        is MoviesListState.Success -> state.RenderState(onAction)
    }
}