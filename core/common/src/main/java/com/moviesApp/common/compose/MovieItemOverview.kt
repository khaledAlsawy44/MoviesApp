package com.moviesApp.common.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieOverview


@Composable
fun MovieOverview(
    overview: MovieOverview,
    lines: Int = 2
) {
    Text(
        modifier = Modifier.padding(end = 16.dp),
        text = overview.value,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onBackground,
        maxLines = lines,
        minLines = lines,
        overflow = TextOverflow.Ellipsis
    )
}
@Composable
fun MovieOverview(
    overview: MovieOverview
) {
    Text(
        modifier = Modifier.padding(end = 16.dp),
        text = overview.value,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onBackground,
        overflow = TextOverflow.Ellipsis
    )
}