package com.logoped583st.logger.di

import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.logger.LoggerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface LoggerModule {

    @Singleton
    @Binds
    fun bindLogger(logger: LoggerImpl): Logger
}