package com.logoped583st.network_core.di

import com.logoped583st.network_core.client.NetworkClient
import com.logoped583st.network_core.client.NetworkClientImpl
import com.logoped583st.network_core.converters.DateConverter
import com.logoped583st.network_core.interceptors.BearerInterceptor
import com.google.gson.JsonDeserializer
import com.logoped583st.dagger_component_connector.actions.ServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*
import javax.inject.Singleton

@Module
interface NetworkCoreModule {

    @Singleton
    @Binds
    fun bindDateConverter(dateConverter: DateConverter): JsonDeserializer<Date>

    @Binds
    @BearerInterceptorQualifier
    fun bindBearerInterceptor(interceptor: BearerInterceptor): Interceptor

    @Singleton
    @Binds
    fun bindNetworkClient(client: NetworkClientImpl): NetworkClient

    @Singleton
    @Binds
    fun bindServiceFactory(serviceFactory: ServiceFactoryImpl): ServiceFactory

    companion object {
        @Singleton
        @Provides
        @LoggingInterceptorQualifier
        fun provideLoggingInterceptor(): Interceptor =
                HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                    override fun log(message: String) {
                        // TODO add timber
                    }
                }).apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
    }
}
