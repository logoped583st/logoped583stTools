package com.logoped583st.network_core.di

import com.logoped583st.network_core.client.RefreshTokenHandler
import dagger.BindsInstance
import dagger.Subcomponent
import okhttp3.Authenticator

interface NetworkAuthorizedProvider : NetworkProvider {
    fun provideAuthenticator(): Authenticator
}

@Subcomponent(modules = [NetworkAuthorizedModule::class])
interface NetworkAuthorizedComponent : NetworkAuthorizedProvider {
    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun authHeader(retriever: () -> Pair<String,String>?): Builder

        @BindsInstance
        fun refreshTokenHandler(tokenHandler: RefreshTokenHandler): Builder

        fun build(): NetworkAuthorizedComponent

    }
}