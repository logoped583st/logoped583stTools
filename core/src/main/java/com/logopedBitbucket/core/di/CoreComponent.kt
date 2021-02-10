package com.logopedBitbucket.core.di

import com.logoped583st.network_core.di.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        dependencies = [NetworkProvider::class],
        modules = [BitbucketNetworkClientModule::class, BitbucketConfigModule::class]
)
interface CoreComponent {

}