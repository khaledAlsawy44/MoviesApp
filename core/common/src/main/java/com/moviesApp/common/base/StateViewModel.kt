package com.moviesApp.common.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.moviesApp.common.extintions.handleApiResult
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class StateViewModel<State : Any, Action : Any, Effect : Any>() : ViewModel() {

    private val uiState: MutableState<State?> = mutableStateOf(null)
    fun uiState(): androidx.compose.runtime.State<State?> = uiState

    suspend fun <CallLeftResult, CallRightResult, LeftState, RightState> callApi(
        block: suspend () -> Either<CallLeftResult, CallRightResult>,
        mapErrorResult: (CallLeftResult) -> LeftState,
        mapSuccessResult: suspend (CallRightResult) -> RightState
    ): Any? {
        return block.invoke().handleApiResult(
            mapErrorResult = mapErrorResult,
            mapSuccessResult = mapSuccessResult
        )
    }

    fun launch(context: CoroutineContext = EmptyCoroutineContext, body: suspend () -> Unit) {
        viewModelScope.launch(context) {
            body.invoke()
        }
    }

    fun setState(state: State) {
        uiState.value = state
    }
}

