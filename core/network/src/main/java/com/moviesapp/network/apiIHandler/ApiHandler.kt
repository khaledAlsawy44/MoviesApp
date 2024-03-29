package com.moviesapp.network.apiIHandler

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.moviesApp.business_models.CurrentPage
import com.moviesApp.business_models.PaginatedData
import com.moviesApp.business_models.TotalPages
import com.moviesApp.business_models.AppErrors
import com.moviesapp.network.entities.PaginationResponse
import retrofit2.Response

suspend fun <T> safeApiCall(
    call: suspend () -> Either<AppErrors, T>
): Either<AppErrors, T> {
    return try {
        call.invoke()
    } catch (e: Exception) {
        e.printStackTrace()
        e.toAppErrors().left()
    }
}

fun <T, R> Response<T>.mapResponseData(transformation: (T) -> R?): Either<AppErrors, R> {
    val responseBody = body()
    return if (isSuccessful && responseBody != null) transformation(responseBody)?.right()
        ?: AppErrors.General("Failed To map data").left()
    else AppErrors.General(message()).left()
}

fun <T, R> Response<PaginationResponse<T>>.mapPaginatedResponseData(
    transformation: (T) -> R?
): Either<AppErrors, PaginatedData<R>> {

    val body = body()
    return if (
        isSuccessful &&
        body != null &&
        body.page != null &&
        body.total_pages != null &&
        body.results != null
    ) {
        PaginatedData(
            page = CurrentPage(body.page),
            totalPages = TotalPages(body.total_pages),
            list = body.results.mapNotNull { element -> element?.let { transformation(it) } }
        ).right()
    } else AppErrors.General(message()).left()
}


fun Throwable.toAppErrors(): AppErrors {
    return AppErrors.General(this.message)
}
