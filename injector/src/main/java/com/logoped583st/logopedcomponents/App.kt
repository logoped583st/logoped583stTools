package com.logoped583st.logopedcomponents

import android.app.Application
import com.bitbucket.main_screen.di.initAppRouterProvider
import com.logoped583st.android_tools.di.initAndroidModule
import com.logoped583st.dagger_component_connector.App
import com.logoped583st.dagger_component_connector.di.ApplicationProvider
import com.logoped583st.encryption.di.initEncryption
import com.logoped583st.logger.di.initLoggerProvider
import com.logopedbitbucket.login.di.initAuthProvider

class App : Application(), App {

    companion object {
        lateinit var applicationProvider: ApplicationProvider
    }

    override fun onCreate() {
        super.onCreate()

        applicationProvider = DaggerAppComponent
                .builder()
                .androidToolsProvider(initAndroidModule(this, "bitbucket-app-prefs"))
                .appRouterProvider(initAppRouterProvider())
                .authProvider(initAuthProvider())
                .encryptionProvider(initEncryption("bitbucket-key", this, initLoggerProvider()))
                .build()
    }

    override fun getApplicationComponent(): ApplicationProvider {
        return applicationProvider
    }
}
