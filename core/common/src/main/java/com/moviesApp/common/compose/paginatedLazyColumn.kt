package com.moviesApp.common.compose

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.designSystem.theme.Gold

@Composable
fun <T> List<T>.PaginatedLazyColumn(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical = if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    onLoadMore: () -> Unit,
    content: @Composable LazyListScope.(T) -> Unit,
    canLoadMore: Boolean
) {
    var isLoadingMore by remember { mutableStateOf(false) }

    LaunchedEffect(this.size) {
        isLoadingMore = false
    }
    val contentList = this
    val isScrollToEnd by remember {
        derivedStateOf {
            (listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 5)
                    && listState.isScrollInProgress
        }
    }
    if (isScrollToEnd && canLoadMore) {
        isLoadingMore = true
        onLoadMore.invoke()
    }
    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = contentPadding,
        reverseLayout = reverseLayout,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        flingBehavior = flingBehavior,
        userScrollEnabled = userScrollEnabled,
    ) {
        items(contentList) {
            this@LazyColumn.content(it)
        }
        item {
            if (isLoadingMore) CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                color = Gold
            )
        }
    }
}
