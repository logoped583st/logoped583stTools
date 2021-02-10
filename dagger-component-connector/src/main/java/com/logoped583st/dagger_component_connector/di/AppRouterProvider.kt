package com.logoped583st.dagger_component_connector.di

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface AppRouterProvider {
    fun providerRouter(): Router

    fun provideNavigationHolder(): NavigatorHolder
}