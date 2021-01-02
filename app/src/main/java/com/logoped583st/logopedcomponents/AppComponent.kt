package com.logoped583st.logopedcomponents

import android.content.Context
import com.logoped583st.android_tools.di.initAndroidModule
import com.logoped583st.dagger_component_connector.di.AndroidToolsProvider
import com.logoped583st.dagger_component_connector.di.ApplicationProvider
import com.logoped583st.dagger_component_connector.di.EncryptionProvider
import com.logoped583st.encryption.di.initEncryption
import com.logoped583st.logger.di.initLoggerComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [EncryptionProvider::class, AndroidToolsProvider::class])
interface AppComponent : ApplicationProvider {

    fun inject(mainActivity: MainActivity)
}

fun initApp(context: Context): AppComponent {

    val logger = initLoggerComponent()
    val encryptionProvider = initEncryption("test", context, logger.provideLogger())

    val toolsProvider = initAndroidModule(context,"base-prefs")
    return DaggerAppComponent.builder()
            .encryptionProvider(encryptionProvider)
            .androidToolsProvider(toolsProvider)
            .build()
}