package com.moviesApp.common.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp

@Composable
fun RenderEmptyState(
    title: String,
    iconRes: Int,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "",
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )
        if (title.isNotBlank()) {
            Text(
                text = title,
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Normal,
                    textDirection = TextDirection.Content

                )
            )
        }
    }
}
