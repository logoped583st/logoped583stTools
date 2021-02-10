package com.logopedBitbucket.core.di

import com.logoped583st.network_core.client.NetworkClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object BitbucketNetworkClientModule {

    @Provides
    fun provideRetrofit(networkClient: NetworkClient): Retrofit {
        return networkClient.retrofitClient()
                .build()
    }
}