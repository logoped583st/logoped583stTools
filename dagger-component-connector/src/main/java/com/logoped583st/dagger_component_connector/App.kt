package com.logoped583st.dagger_component_connector

import com.logoped583st.dagger_component_connector.di.ApplicationProvider

interface App {
    fun getApplicationComponent(): ApplicationProvider
}