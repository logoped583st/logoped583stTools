package com.example.network_core.di

import com.example.network_core.converters.DateConverter
import com.example.network_core.interceptors.*
import com.google.gson.JsonDeserializer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*
import javax.inject.Singleton

@Module(includes = [NetworkCoreModule::class])
interface NetworkCoreModule {

    @Singleton
    @Binds
    fun bindDateConverter(dateConverter: DateConverter): JsonDeserializer<Date>

    @Singleton
    @Binds
    fun bindInterceptorFactory(interceptorFactory: InterceptorFactoryImpl): InterceptorFactory

    @Singleton
    @Binds
    @IntoMap
    @InterceptorKey(InterceptorType.Auth)
    fun bindAuthInterceptor(interceptor: BearerInterceptor): Interceptor

    companion object {
        @Singleton
        @Provides
        @IntoMap
        @InterceptorKey(InterceptorType.Logging)
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