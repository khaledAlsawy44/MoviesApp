package com.moviesApp.movieslist.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviesApp.business_models.MovieRate
import com.moviesApp.business_models.MovieRateCount
import com.moviesApp.designSystem.atoms.HorizontalSpace
import com.moviesApp.designSystem.theme.Gold

@Composable
fun MovieRate(rate: MovieRate, rateCount: MovieRateCount) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, start = 16.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Gold
            )
            HorizontalSpace(space = 8.dp)
            Text(
                text = rate.value.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            HorizontalSpace(space = 8.dp)
            Text(
                text = "( ${rateCount.value} )",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}