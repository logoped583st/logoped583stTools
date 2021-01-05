package com.logoped583st.arch_core.di

import androidx.lifecycle.ViewModelProvider
import com.logoped583st.arch_core.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}