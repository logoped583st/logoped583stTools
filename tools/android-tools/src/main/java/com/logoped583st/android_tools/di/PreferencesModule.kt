package com.logoped583st.android_tools.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class PreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(context: Context, prefsName: String): SharedPreferences {
        return context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    }

}