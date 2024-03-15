package com.moviesApp.common.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.moviesApp.business_models.AppErrors
import com.moviesApp.common.R

@Composable
fun RenderErrorState(
    title: String = stringResource(id = R.string.general_error_title),
    errorMessage: AppErrors,
    confirmButtonMessage: String = stringResource(id = R.string.close),
    userCanDismiss: Boolean = true,
    onTryClick: () -> Unit = {}
) {
    ErrorDialog(
        title = title,
        errorMessage = errorMessage.message ?: stringResource(id = R.string.general_error_message),
        confirmButtonMessage = confirmButtonMessage,
        userCanDismiss = userCanDismiss
    ) {
        onTryClick.invoke()
    }
}
