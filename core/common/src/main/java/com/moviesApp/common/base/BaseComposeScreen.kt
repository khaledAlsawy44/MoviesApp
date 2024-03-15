package com.moviesApp.common.base

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
inline fun <State : Any, Action : Any, Effect : Any, reified viewModel : StateViewModel<State, Action, Effect>> BaseComposeScreen(
    content: @Composable (state: State, onAction: (Action) -> Unit) -> Unit
) {
    val viewModel: viewModel = hiltViewModel()
    val state = viewModel.uiState().value
    state?.let {
        content.invoke(it) { action -> viewModel.onAction(action) }
    }
}
