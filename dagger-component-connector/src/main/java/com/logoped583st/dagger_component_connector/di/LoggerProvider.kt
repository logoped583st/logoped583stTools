package com.logoped583st.dagger_component_connector.di

interface Logger {
    fun httpLog(message: String)

    fun exceptionLog(throwable: Throwable)
}

interface LoggerProvider {
    fun provideLogger(logger: Logger)
}