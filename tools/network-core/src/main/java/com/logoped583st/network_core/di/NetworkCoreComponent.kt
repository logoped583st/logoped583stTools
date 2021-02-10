package com.logoped583st.network_core.di

import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.network_core.client.NetworkClient
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton


interface NetworkProvider {
    fun provideNetworkClient(): NetworkClient
}

@Singleton
@Component(
        modules = [NetworkCoreModule::class]
)
interface NetworkCoreComponent : NetworkProvider {

    fun authorizedNetworkComponent(): NetworkAuthorizedComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun logger(logger: Logger): Builder

        @BindsInstance
        fun requestScheduler(scheduler: Scheduler): Builder

        @BindsInstance
        fun baseUrl(url: String): Builder


        fun build(): NetworkCoreComponent
    }

}

