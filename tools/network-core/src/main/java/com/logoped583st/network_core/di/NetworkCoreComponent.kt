package com.logoped583st.network_core.di

import com.logoped583st.dagger_component_connector.di.NetworkProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkCoreModule::class])
interface NetworkCoreComponent : NetworkProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance authTokenReceiver: () -> String): NetworkCoreComponent
    }

    companion object {
        fun init(): NetworkProvider {
            return DaggerNetworkCoreComponent.factory()
                    .create { "asd" }
        }
    }


}