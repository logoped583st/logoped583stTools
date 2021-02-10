package com.logopedbitbucket.login.di.modules

import com.logoped583st.network_core.client.NetworkClient
import com.logopedbitbucket.login.api.AuthApi
import com.logopedbitbucket.login.di.AuthScope
import dagger.Module
import dagger.Provides

@Module
internal interface NetworkModule {

    companion object {
        @Provides
        @AuthScope
        fun bindAuthApi(networkClient: NetworkClient): AuthApi {
            return networkClient.retrofitClient()
                    .build()
                    .create(AuthApi::class.java)
        }
    }

}