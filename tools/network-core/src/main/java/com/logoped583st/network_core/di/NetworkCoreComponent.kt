package com.logoped583st.network_core.di

import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.network_core.client.NetworkClient
import com.logoped583st.network_core.client.RefreshTokenHandler
import com.logoped583st.network_core.interceptors.InterceptorFactory
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.core.Scheduler
import okhttp3.Authenticator
import javax.inject.Singleton


interface NetworkProvider {

    fun provideNetworkClient(): NetworkClient

    fun provideInterceptorsFactory(): InterceptorFactory

    fun provideAuthenticator(): Authenticator

}

@Singleton
@Component(
        modules = [NetworkCoreModule::class]
)
interface NetworkCoreComponent : NetworkProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun logger(logger: Logger): Builder

        @BindsInstance
        fun requestScheduler(scheduler: Scheduler): Builder

        @BindsInstance
        fun refreshTokenHandler(tokenHandler: RefreshTokenHandler): Builder

        @BindsInstance
        fun baseUrl(url: String): Builder

        @BindsInstance
        fun tokenRetriever(retriever: () -> String?): Builder

        fun build(): NetworkCoreComponent
    }
}

