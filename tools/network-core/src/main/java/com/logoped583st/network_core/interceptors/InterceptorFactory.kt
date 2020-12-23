package com.logoped583st.network_core.interceptors

import dagger.MapKey
import okhttp3.Interceptor
import javax.inject.Inject

interface InterceptorFactory {
    fun provideInterceptor(type: InterceptorType): Interceptor
}

enum class InterceptorType {
    Logging,
    Bearer
}

@MapKey
annotation class InterceptorKey(val type: InterceptorType)

internal class InterceptorFactoryImpl @Inject constructor(
        private val interceptors: Map<InterceptorType, Interceptor>
) : InterceptorFactory {

    override fun provideInterceptor(type: InterceptorType): Interceptor {
        return interceptors[type]
                ?: throw IllegalArgumentException("interceptro $type doesn't exist")
    }

}
