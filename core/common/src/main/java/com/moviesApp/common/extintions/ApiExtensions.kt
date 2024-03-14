package com.moviesApp.common.extintions

import arrow.core.Either

suspend fun <Left, Right, LeftState, RightState> Either<Left, Right>.handleApiResult(
    mapErrorResult: (Left) -> LeftState,
    mapSuccessResult: suspend (Right) -> RightState
): Any? {
    return when (this) {
        is Either.Left -> mapErrorResult(value)
        is Either.Right -> mapSuccessResult(value)
    }
}