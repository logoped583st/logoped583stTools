package com.logoped583st.network_core.di

import com.google.gson.JsonDeserializer
import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.network_core.client.NetworkClient
import com.logoped583st.network_core.client.NetworkClientImpl
import com.logoped583st.network_core.client.TokenAuthenticator
import com.logoped583st.network_core.converters.DateConverter
import com.logoped583st.network_core.interceptors.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*
import javax.inject.Singleton

@Module
internal interface NetworkCoreModule {

    @Singleton
    @Binds
    fun bindDateConverter(dateConverter: DateConverter): JsonDeserializer<Date>

    @Singleton
    @Binds
    @IntoMap
    @InterceptorKey(InterceptorType.Bearer)
    fun bindBearerInterceptor(interceptor: BearerInterceptor): Interceptor

    @Binds
    fun bindNetworkClient(client: NetworkClientImpl): NetworkClient

    @Binds
    @Singleton
    fun interceptorFactory(interceptorFactory: InterceptorFactoryImpl): InterceptorFactory

    @Binds
    @Singleton
    fun bindAuthenticator(authenticator: TokenAuthenticator): Authenticator

    @Module
    companion object {
        @Singleton
        @Provides
        @IntoMap
        @InterceptorKey(InterceptorType.Logging)
        fun provideLoggingInterceptor(logger: Logger): Interceptor =
                HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                    override fun log(message: String) {
                        logger.httpLog(message)
                    }
                }).apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
    }

}

