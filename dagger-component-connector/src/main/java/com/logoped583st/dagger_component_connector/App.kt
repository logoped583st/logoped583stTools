package com.logoped583st.dagger_component_connector

import android.app.Application
import com.logoped583st.dagger_component_connector.di.ApplicationProvider

interface App {
    fun getApplicationComponent(): ApplicationProvider
}

fun Application.component(): ApplicationProvider {
    return (this as App).getApplicationComponent()
}