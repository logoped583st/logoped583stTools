package com.logoped583st.logopedcomponents

import com.logoped583st.dagger_component_connector.di.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [EncryptionProvider::class,
    AndroidToolsProvider::class,
    AppRouterProvider::class,
    AuthProvider::class
])
interface AppComponent : ApplicationProvider