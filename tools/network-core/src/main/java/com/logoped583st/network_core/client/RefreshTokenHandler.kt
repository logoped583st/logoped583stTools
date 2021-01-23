package com.logoped583st.network_core.client

import retrofit2.Call

interface RefreshTokenHandler {

    fun refreshToken(): Call<out TokenResponse>

    fun onTokenRefresh(token: TokenResponse)
}

interface TokenResponse {
    val token: String
}