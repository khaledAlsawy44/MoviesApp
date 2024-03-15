package com.moviesApp.movieslist.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.Movie
import com.moviesApp.business_models.MovieId
import com.moviesApp.business_models.MovieOverview
import com.moviesApp.business_models.MoviePosterUrl
import com.moviesApp.business_models.MovieRate
import com.moviesApp.business_models.MovieRateCount
import com.moviesApp.business_models.MovieReleaseDate
import com.moviesApp.business_models.MovieTitle
import com.moviesApp.movieslist.MoviesListActions
import java.time.LocalDate

@Composable
fun MovieItem(
    movie: Movie,
    onAction: (MoviesListActions) -> Unit
) {
    Box(
        Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(140.dp)
    ) {
        MovieInfo(movie = movie) {
            onAction.invoke(MoviesListActions.OnMoveClicked(movie.id))
        }
        MovieImage(posterUrl = movie.posterUrl) {
            onAction.invoke(MoviesListActions.OnMoveClicked(movie.id))
        }
    }

}


@Preview
@Composable
fun MovieItemPrev() {
    MovieItem(
        Movie(
            id = MovieId(123),
            title = MovieTitle("title"),
            posterUrl = MoviePosterUrl("https://image.tmdb.org/t/p/original/iIKYK9mdapWlJ21YNRGB57WKErK.jpg"),
            overview = MovieOverview("overview overviewov erviewoverv iewoverview overviewov erviewoverviewoverviewoverv iewoverview"),
            movieRate = MovieRate(20.0),
            rateCount = MovieRateCount(30),
            releaseDate = MovieReleaseDate(LocalDate.now())
        ),
        {}
    )
}