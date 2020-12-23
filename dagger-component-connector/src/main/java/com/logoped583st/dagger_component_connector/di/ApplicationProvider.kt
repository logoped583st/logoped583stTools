package com.logoped583st.dagger_component_connector.di

interface ApplicationProvider

interface LoggerProvider {
    fun provideLogger(logger: Logger)
}
