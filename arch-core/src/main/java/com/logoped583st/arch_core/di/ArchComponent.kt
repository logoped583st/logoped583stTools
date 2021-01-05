package com.logoped583st.arch_core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Provider

@Component(modules = [ViewModelModule::class])
interface ArchComponent : ArchProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance map: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ArchComponent
    }
}

interface ArchProvider {
    fun provideViewModelFactory(): ViewModelProvider.Factory
}