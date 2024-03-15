package com.moviesApp.movieslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.common.compose.RenderEmptyState
import com.moviesApp.common.compose.RenderErrorState
import com.moviesApp.common.compose.RenderLoadingState
import com.moviesApp.common.compose.SearchTextFiled
import com.moviesApp.designSystem.atoms.VerticalSpace
import com.moviesApp.movieslist.compose.RenderState


@Composable
fun MoviesListScreenContent(
    state: MoviesListState,
    onAction: (MoviesListActions) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(Modifier.padding(horizontal = 16.dp)) {
        VerticalSpace(16.dp)
        SearchTextFiled(
            query = searchQuery,
            onQueryChanged = {
                searchQuery = it
                onAction.invoke(MoviesListActions.OnSearch(it))
            }
        )
        VerticalSpace(16.dp)

        when (state) {
            is MoviesListState.Error -> RenderErrorState(errorMessage = state.error)
            MoviesListState.Loading -> RenderLoadingState()
            is MoviesListState.Success -> state.RenderState(onAction)
            MoviesListState.Empty -> RenderEmptyState()
        }
    }


}