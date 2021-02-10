package com.logopedbitbucket.login.di

import com.logoped583st.dagger_component_connector.di.AuthProvider
import com.logopedbitbucket.login.di.modules.OpenAuthScreenModule
import dagger.Component

@Component(modules = [OpenAuthScreenModule::class])
interface AuthExportComponent : AuthProvider

fun initAuthProvider(): AuthProvider{
    return DaggerAuthExportComponent
            .builder()
            .build()
}