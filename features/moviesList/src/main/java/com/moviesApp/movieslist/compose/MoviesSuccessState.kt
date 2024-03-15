package com.moviesApp.movieslist.compose

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.moviesApp.common.compose.PaginatedLazyColumn
import com.moviesApp.movieslist.MoviesListActions
import com.moviesApp.movieslist.MoviesListState

@Composable
fun MoviesListState.Success.RenderState(
    onAction: (MoviesListActions) -> Unit
) {
    val listState: LazyListState = rememberLazyListState()

    movies.list.PaginatedLazyColumn(
        listState = listState,
        onLoadMore = { onAction.invoke(MoviesListActions.OnLoadMore) },
        content = { MovieItem(movie = it, onAction = onAction) },
        canLoadMore = movies.page.value < movies.totalPages.value,
    )
}