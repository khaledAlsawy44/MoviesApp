package com.moviesApp.movieDetails.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.BackdropUrl
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.business_models.MovieId
import com.moviesApp.business_models.MovieOverview
import com.moviesApp.business_models.MoviePosterUrl
import com.moviesApp.business_models.MovieRate
import com.moviesApp.business_models.MovieRateCount
import com.moviesApp.business_models.MovieReleaseDate
import com.moviesApp.business_models.MovieStatus
import com.moviesApp.business_models.MovieTitle
import com.moviesApp.designSystem.atoms.VerticalSpace
import com.moviesApp.movieDetails.MovieDetailsState
import java.time.LocalDate

@Composable
fun MovieDetailsState.Success.RenderState(
    onBackClicked: () -> Unit
) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            MovieBanner(movieDetails)
            MovieInfo(movieDetails)

            Icon(
                modifier = Modifier
                    .padding(16.dp)
                    .background(color = MaterialTheme.colorScheme.surface, shape = CircleShape)
                    .clip(CircleShape)
                    .clickable { onBackClicked.invoke() }
                    .padding(8.dp),
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        MovieGenres(movieDetails)
        VerticalSpace(space = 32.dp)
    }
}

@Preview
@Composable
fun MovieItemDetailsPrev() {
    MovieDetailsState.Success(
        MovieDetails(
            id = MovieId(123),
            title = MovieTitle("title"),
            posterUrl = MoviePosterUrl("https://image.tmdb.org/t/p/original/iIKYK9mdapWlJ21YNRGB57WKErK.jpg"),
            overview = MovieOverview("overview overviewov erviewoverv iewoverview overviewov erviewoverviewoverviewoverv iewoverview"),
            rate = MovieRate(20.0),
            rateCount = MovieRateCount(30),
            releaseDate = MovieReleaseDate(LocalDate.now()),
            backdropUrl = BackdropUrl(""),
            productionCompanies = emptyList(),
            status = MovieStatus(""),
            genres = emptyList()
        )
    ).RenderState() {}
}