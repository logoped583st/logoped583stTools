package com.logoped583st.network_core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val authorizationHeader = "Authorization"
private const val bearerPrefix = "Bearer"

internal class BearerInterceptor @Inject constructor(
    private val tokenReceiver: () -> String?
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            proceed(request().newBuilder().apply {
                val token = tokenReceiver()
                if (!token.isNullOrBlank()) {
                    addHeader(authorizationHeader, "$bearerPrefix $token")
                }
            }.build())
        }
    }
}
