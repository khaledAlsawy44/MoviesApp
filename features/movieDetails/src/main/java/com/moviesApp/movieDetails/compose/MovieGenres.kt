package com.moviesApp.movieDetails.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieDetails
import com.moviesApp.designSystem.atoms.HorizontalSpace

@Composable
fun MovieGenres(movieDetails: MovieDetails) {
    MovieGenresTitle()
    LazyRow(Modifier.padding(top = 8.dp)) {
        item { HorizontalSpace(space = 24.dp) }
        items(movieDetails.genres) {
            MovieGenresItem(it.value)
            HorizontalSpace(space = 8.dp)
        }
    }
}


@Composable
fun MovieGenresTitle() {
    Text(
        modifier = Modifier.padding(start = 24.dp, top = 24.dp),
        text = "Genres",
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.onSurface,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MovieGenresItem(text: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 2.dp,
        color = MaterialTheme.colorScheme.surface,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(),
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}