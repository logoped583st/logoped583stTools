package com.example.network_core.interceptors

import dagger.MapKey
import okhttp3.Interceptor
import javax.inject.Inject

interface InterceptorFactory {
    fun provideInterceptor(interceptorKey: InterceptorType): Interceptor
}

@MapKey
annotation class InterceptorKey(val type: InterceptorType)

enum class InterceptorType {
    Logging,
    Auth
}

class InterceptorFactoryImpl @Inject constructor(
    private val creator: Map<InterceptorType, Interceptor>
): InterceptorFactory {

    override fun provideInterceptor(interceptorKey: InterceptorType): Interceptor {
        return creator[interceptorKey]?: throw IllegalArgumentException("invalid key ${interceptorKey.name}")
    }

}