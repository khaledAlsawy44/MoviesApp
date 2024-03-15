package com.moviesApp.movieslist.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.Movie
import com.moviesApp.common.compose.MovieOverview
import com.moviesApp.common.compose.MovieRate
import com.moviesApp.common.compose.MovieReleaseDate
import com.moviesApp.common.compose.MovieTitle
import com.moviesApp.designSystem.atoms.VerticalSpace


@Composable
fun BoxScope.MovieInfo(
    movie: Movie,
    onMovieClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomStart),
        shape = RoundedCornerShape(
            bottomEnd = 10.dp,
            topStart = 10.dp,
            bottomStart = 20.dp,
            topEnd = 20.dp
        ),
        color = MaterialTheme.colorScheme.surface,
        onClick = { onMovieClicked.invoke() },
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(start = 104.dp, top = 8.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            MovieTitle(movie.title)
            VerticalSpace(space = 4.dp)
            MovieOverview(overview = movie.overview, lines = 2)
            VerticalSpace(space = 8.dp)
            Row(verticalAlignment = Alignment.Top) {
                movie.releaseDate?.let { MovieReleaseDate(date = it) }
                Spacer(modifier = Modifier.weight(1f))
                MovieRate(rate = movie.movieRate, rateCount = movie.rateCount)
            }
        }
    }

}