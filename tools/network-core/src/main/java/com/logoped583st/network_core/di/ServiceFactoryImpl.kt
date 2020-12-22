package com.logoped583st.network_core.di

import com.logoped583st.network_core.client.NetworkClient
import com.logoped583st.dagger_component_connector.actions.ServiceFactory
import okhttp3.Interceptor
import javax.inject.Inject

class ServiceFactoryImpl @Inject constructor(
        private val networkClient: NetworkClient,
        @BearerInterceptorQualifier private val bearerInterceptor: Interceptor
) : ServiceFactory {

    override fun <S> createService(baseUrl: String, service: Class<S>): S {
        return networkClient.retrofitClient(baseUrl)
                .client(
                        networkClient.okhttpClient()
                                .addInterceptor(bearerInterceptor)
                                .build()
                )
                .build()
                .create(service)

    }


}