package com.moviesApp.movieslist.compose

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MoviePosterUrl
import com.moviesApp.designSystem.components.ComponentRemoteImage


@Composable
fun BoxScope.MovieImage(
    posterUrl: MoviePosterUrl,
    onMovieClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(start = 12.dp, bottom = 12.dp)
            .width(80.dp)
            .height(125.dp),
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