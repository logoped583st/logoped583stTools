package com.logoped583st.network_core.client

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.HttpException
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
        private val refreshTokenHandler: RefreshTokenHandler,
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {


        val tokenResponse = refreshTokenHandler.refreshToken().execute()

        if (!tokenResponse.isSuccessful) {
            throw HttpException(tokenResponse)
        }

        return tokenResponse.body()?.let {

            refreshTokenHandler.onTokenRefresh(it)

            response.request
        }

    }
}
