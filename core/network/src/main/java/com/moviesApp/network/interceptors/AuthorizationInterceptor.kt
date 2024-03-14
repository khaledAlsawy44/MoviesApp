package com.moviesApp.network.interceptors

import com.moviesApp.mylibrary.BuildConfig
import com.moviesApp.network.PARAMETER_API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor(
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().apply {
            this.newBuilder().url(
                url.newBuilder()
                    .addQueryParameter(PARAMETER_API_KEY, BuildConfig.API_KEY)
                    .build()
            ).build()
        }

        return chain.proceed(request)
    }
}
