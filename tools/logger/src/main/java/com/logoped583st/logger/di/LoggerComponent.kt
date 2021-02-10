package com.logoped583st.logger.di

import com.logoped583st.dagger_component_connector.di.LoggerProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoggerModule::class])
internal interface LoggerComponent : LoggerProvider

fun initLoggerProvider(): LoggerProvider {
    return DaggerLoggerComponent
            .create()
}