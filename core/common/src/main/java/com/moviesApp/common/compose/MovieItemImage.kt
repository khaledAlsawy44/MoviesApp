package com.moviesApp.common.compose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MoviePosterUrl
import com.moviesApp.designSystem.components.ComponentRemoteImage


@Composable
fun MovieImage(
    modifier: Modifier,
    posterUrl: MoviePosterUrl,
    onMovieClicked: () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = 10.dp,
            bottomEnd = 10.dp,
            topEnd = 20.dp,
            bottomStart = 20.dp
        ),
        shadowElevation = 12.dp,
        tonalElevation = 8.dp,
        onClick = { onMovieClicked.invoke() }
    ) {
        ComponentRemoteImage(imageUrl = posterUrl.value)
    }

}