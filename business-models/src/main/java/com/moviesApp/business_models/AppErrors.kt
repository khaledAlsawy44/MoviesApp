package com.moviesApp.business_models


sealed class AppErrors {
    abstract val message: String?

    data class General(override val message: String? = null) : AppErrors()

    // Another App Errors , can be used for App specific errors
}