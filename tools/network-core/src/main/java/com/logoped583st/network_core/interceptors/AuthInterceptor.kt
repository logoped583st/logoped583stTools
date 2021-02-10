package com.logoped583st.network_core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class AuthInterceptor @Inject constructor(
        private val retriever: () -> Pair<String, String>?
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            proceed(request().newBuilder().apply {
                val header = retriever()
                if (header != null) {
                    addHeader(header.first, header.second)
                }
            }.build())
        }
    }
}
