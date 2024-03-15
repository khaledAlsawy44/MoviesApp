package com.moviesApp.movieDetails.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.common.compose.MovieOverview
import com.moviesApp.common.compose.MovieRate
import com.moviesApp.common.compose.MovieReleaseDate
import com.moviesApp.common.compose.MovieTitle
import com.moviesApp.designSystem.atoms.VerticalSpace

@Composable
fun MovieInfoCard(movieDetails: MovieDetails) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 10.dp
                )
            )
            .padding(start = 140.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        VerticalSpace(space = 8.dp)
        MovieTitle(movieDetails.title)
        VerticalSpace(space = 4.dp)
        MovieOverview(overview = movieDetails.overview)
        VerticalSpace(space = 8.dp)
        Row(verticalAlignment = Alignment.Top) {
            movieDetails.releaseDate?.let { MovieReleaseDate(date = it) }
            Spacer(modifier = Modifier.weight(1f))
            MovieRate(rate = movieDetails.rate, rateCount = movieDetails.rateCount)
        }
    }
}