package com.logoped583st.network_core.client

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject


class TokenAuthenticator @Inject constructor() : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request {
        val updatedToken = "asd"

        return updatedToken.let {
            response.request
                    .newBuilder()
                    .header("Authorization", it)
                    .build()
        }

    }


}