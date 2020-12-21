package com.example.network_core.di

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface NetworkCoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance authTokenReceiver: () -> String): NetworkCoreComponent
    }

}