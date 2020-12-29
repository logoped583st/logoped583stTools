package com.logoped583st.dagger_component_connector.di

import android.content.SharedPreferences

interface AndroidToolsProvider {

    fun providePreferences(): SharedPreferences

}