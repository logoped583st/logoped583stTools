package com.logoped583st.network_core.client

import retrofit2.Call

interface RefreshTokenHandler {

    val refreshTokenService: Class<out RefreshTokenService>

    fun onTokenRefresh(token: TokenResponse)
}

interface RefreshTokenService {
    fun refreshToken(): Call<out TokenResponse>
}

interface TokenResponse {
    val token: String
}