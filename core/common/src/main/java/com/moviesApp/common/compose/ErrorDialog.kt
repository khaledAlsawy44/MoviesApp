package com.moviesApp.common.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moviesApp.common.R

@Composable
fun ErrorDialog(
    title: String,
    errorMessage: String,
    confirmButtonMessage: String = stringResource(id = R.string.close),
    userCanDismiss: Boolean = true,
    onClose: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) ErrorDialog(
        title = title,
        errorMessage = errorMessage,
        confirmButtonMessage = confirmButtonMessage,
        onClose = {
            if (userCanDismiss) openDialog.value = false
            onClose.invoke()
        }
    )
}

@Composable
private fun ErrorDialog(
    title: String,
    errorMessage: String,
    confirmButtonMessage: String,
    onClose: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onClose() },
        title = {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_error_icon),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        text = {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        confirmButton = {
            Button(
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    onClose()
                }
            ) {
                Text(text = confirmButtonMessage)
            }
        },
        modifier = Modifier.padding(16.dp)
    )
}
