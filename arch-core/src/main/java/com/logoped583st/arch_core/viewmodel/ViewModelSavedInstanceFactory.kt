package com.logoped583st.arch_core.viewmodel

import android.os.Bundle
import androidx.annotation.MainThread
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

interface ViewModelSavedInstanceFactory<out V : ViewModel> {
    fun create(handle: SavedStateHandle): V
}

class GenericSavedStateViewModelFactory<out V : ViewModel>(
        private val viewModelFactory: ViewModelSavedInstanceFactory<V>,
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
    ): T {
        return viewModelFactory.create(handle) as T
    }
}

@MainThread
inline fun <reified VM : ViewModel> SavedStateRegistryOwner.withFactory(
        factory: ViewModelSavedInstanceFactory<VM>,
        defaultArgs: Bundle? = null
) = GenericSavedStateViewModelFactory(factory, this, defaultArgs)
