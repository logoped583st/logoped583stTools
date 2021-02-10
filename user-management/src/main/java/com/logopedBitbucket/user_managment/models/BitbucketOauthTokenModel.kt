package com.logopedBitbucket.user_managment.models

data class BitbucketOauthTokenModel(
        val accessToken: String,
        val refreshToken: String
)