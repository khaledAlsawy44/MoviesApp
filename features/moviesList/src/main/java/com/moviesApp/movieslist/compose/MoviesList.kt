package com.moviesApp.movieslist.compose

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.PaginatedData
import com.moviesApp.common.compose.PaginatedLazyColumn
import com.moviesApp.movieslist.MoviesListActions

@Composable
fun MoviesList(
    movies: PaginatedData<Movie>,
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