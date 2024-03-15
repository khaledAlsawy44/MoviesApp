package com.moviesApp.movieDetails.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieDetails

@Composable
fun BoxScope.MovieInfo(movieDetails: MovieDetails) {
    Box(
        Modifier
            .align(Alignment.BottomStart)
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .padding(start = 24.dp, top = 475.dp)
    ) {
        MovieInfoCard(movieDetails)
        MovieInfoImage(movieDetails)
    }

}