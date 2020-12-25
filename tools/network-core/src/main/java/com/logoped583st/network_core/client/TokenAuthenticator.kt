package com.logoped583st.network_core.client

import dagger.Lazy
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.HttpException
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
        private val refreshToken: Lazy<RefreshTokenHandler>,
        private val networkClient: NetworkClient
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {

        val tokenRefreshHandler = refreshToken.get()
                ?: throw RuntimeException("refresh api service is not initialized")

        val tokenRefreshTokenService = networkClient.retrofitClient()
                .build()
                .create(tokenRefreshHandler.refreshTokenService)

        val tokenResponse = tokenRefreshTokenService.refreshToken().execute()

        if (!tokenResponse.isSuccessful) {
            throw HttpException(tokenResponse)
        }

        return tokenResponse.body()?.let {

            tokenRefreshHandler.onTokenRefresh(it)

            response.request
                    .newBuilder()
                    .header("Authorization", it.token)
                    .build()
        }

    }
}