package com.moviesApp.movieDetails.compose

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.common.compose.MovieImage

@Composable
fun BoxScope.MovieInfoImage(movieDetails: MovieDetails) {
    MovieImage(
        modifier = Modifier
            .align(Alignment.TopStart)
            .fillMaxHeight()
            .width(130.dp),
        posterUrl = movieDetails.posterUrl
    ) {}
}