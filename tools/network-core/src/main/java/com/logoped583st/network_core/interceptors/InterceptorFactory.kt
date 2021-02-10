package com.logoped583st.network_core.interceptors

import dagger.MapKey
import okhttp3.Interceptor
import javax.inject.Inject

interface InterceptorFactory {
    fun provideInterceptor(type: InterceptorType): Interceptor
}

enum class InterceptorType {
    Logging,
    Auth
}

@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class InterceptorKey(val type: InterceptorType)

internal class InterceptorFactoryImpl @Inject constructor(
        private val interceptors: Map<InterceptorType, @JvmSuppressWildcards Interceptor>
) : InterceptorFactory {

    override fun provideInterceptor(type: InterceptorType): Interceptor {
        return interceptors[type]
                ?: throw IllegalArgumentException("Interceptor ${type.name} doesn't exist")
    }

}
