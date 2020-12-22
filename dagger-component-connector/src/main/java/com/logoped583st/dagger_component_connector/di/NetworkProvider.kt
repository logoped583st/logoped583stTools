package com.logoped583st.dagger_component_connector.di

import com.logoped583st.dagger_component_connector.actions.ServiceFactory

interface NetworkProvider {
    fun provideServiceFactory(): ServiceFactory
}
