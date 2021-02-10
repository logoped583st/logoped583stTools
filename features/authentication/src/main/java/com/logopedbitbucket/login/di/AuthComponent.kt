package com.logopedbitbucket.login.di

import com.logoped583st.network_core.di.NetworkProvider
import com.logopedbitbucket.login.di.modules.NetworkModule
import dagger.Component
import javax.inject.Scope

@AuthScope
@Component(
        dependencies = [NetworkProvider::class],
        modules = [NetworkModule::class])
internal interface AuthComponent {

}

@Scope
annotation class AuthScope

