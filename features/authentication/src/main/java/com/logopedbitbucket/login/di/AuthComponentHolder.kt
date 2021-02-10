package com.logopedbitbucket.login.di

import com.example.dagger_component_holder.ComponentHolder

internal object AuthComponentHolder : ComponentHolder<AuthComponent>() {
    override fun initComponent(): AuthComponent {
        TODO()

//        return DaggerAuthComponent.builder()
//                .networkProvider(initNetworkProvider(
//
//                ))
//                .build()
    }
}
