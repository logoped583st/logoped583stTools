package com.logopedBitbucket.user_managment

interface TokenCache<T> {
    fun updateToken(token: T)

    fun getToken(): T
}