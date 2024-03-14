package com.moviesapp.network.interceptors

import com.moviesapp.network.BuildConfig
import com.moviesapp.network.PARAMETER_API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor(
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(PARAMETER_API_KEY, BuildConfig.API_KEY)
            .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}
