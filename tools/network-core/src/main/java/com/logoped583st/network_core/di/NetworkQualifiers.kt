package com.logoped583st.network_core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BearerInterceptorQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoggingInterceptorQualifier