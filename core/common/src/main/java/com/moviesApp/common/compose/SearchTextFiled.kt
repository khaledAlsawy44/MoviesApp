package com.moviesApp.common.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviesApp.common.R

@Composable
fun SearchTextFiled(
    query: String = "",
    placeholder: String = stringResource(id = R.string.search),
    onQueryChanged: (value: String) -> Unit,
    horizontalPadding: Dp = 0.dp
) {
    TextField(
        modifier = Modifier
            .padding(horizontal = horizontalPadding)
            .fillMaxWidth(),
        value = query,
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        onValueChange = {
            onQueryChanged.invoke(it)
        },
        singleLine = true,
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "")
        }

    )
}