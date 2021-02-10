package com.logopedbitbucket.login.api

import io.reactivex.rxjava3.core.Completable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

internal interface AuthApi {

    @FormUrlEncoded
    @POST("oauth2/access_token")
    fun oauthClientCode(
            @Field("grant_type") grantType: String,
            @Field("code") code: String,
            @Field("client_id") clientId: String,
            @Field("client_secret") clientSecret: String
    ): Completable

    @FormUrlEncoded
    @POST("oauth2/access_token")
    fun refreshToken(
            @Field("grant_type") grantType: String,
            @Field("refresh_token") refreshToken: String,
            @Field("client_id") clientId: String,
            @Field("client_secret") clientSecret: String
    ): Completable
}