package com.moviesApp.movieDetails.compose

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.designSystem.components.ComponentRemoteImage

@Composable
fun BoxScope.MovieBanner(movieDetails: MovieDetails) {
    ComponentRemoteImage(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
            .height(500.dp),
        imageUrl = movieDetails.backdropUrl.value,
        scale = ContentScale.Crop
    )

}