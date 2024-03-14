package com.moviesApp.designSystem.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


@Composable
fun ComponentRemoteImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = imageUrl)
                .build()
        ),
        contentDescription = "",
        contentScale = ContentScale.Fit
    )
}