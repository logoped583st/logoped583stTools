package com.logoped583st.network_core.di

import com.logoped583st.network_core.client.TokenAuthenticator
import com.logoped583st.network_core.interceptors.AuthInterceptor
import com.logoped583st.network_core.interceptors.InterceptorKey
import com.logoped583st.network_core.interceptors.InterceptorType
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import okhttp3.Authenticator
import okhttp3.Interceptor

@Module
internal interface NetworkAuthorizedModule {
    @Binds
    fun bindAuthenticator(authenticator: TokenAuthenticator): Authenticator

    @Binds
    @IntoMap
    @InterceptorKey(InterceptorType.Auth)
    fun bindBearerInterceptor(interceptor: AuthInterceptor): Interceptor
}