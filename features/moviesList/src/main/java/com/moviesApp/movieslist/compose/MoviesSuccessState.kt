package com.moviesApp.movieslist.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.common.compose.SearchTextFiled
import com.moviesApp.designSystem.atoms.VerticalSpace
import com.moviesApp.movieslist.MoviesListActions
import com.moviesApp.movieslist.MoviesListState

@Composable
fun MoviesListState.Success.RenderState(
    onAction: (MoviesListActions) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(Modifier.padding(horizontal = 16.dp)) {
        VerticalSpace(16.dp)
        SearchTextFiled(
            query = searchQuery,
            onQueryChanged = {
                searchQuery = it
            }
        )
        VerticalSpace(16.dp)
        MoviesList(this@RenderState.movies, onAction)

    }
}