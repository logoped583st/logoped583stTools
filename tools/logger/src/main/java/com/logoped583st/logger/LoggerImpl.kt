package com.logoped583st.logger

import com.logoped583st.dagger_component_connector.di.Logger
import timber.log.Timber
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

    init {
        Timber.plant()
    }

    override fun httpLog(message: String) {
        Timber.tag("http").i(message)
    }

    override fun exceptionLog(throwable: Throwable) {
        Timber.e(throwable)
    }
}