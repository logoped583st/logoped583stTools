package com.bitbucket.main_screen.di

import com.bitbucket.main_screen.MainActivity
import com.logoped583st.dagger_component_connector.di.AppRouterProvider
import com.logoped583st.dagger_component_connector.di.ApplicationProvider
import com.logoped583st.dagger_component_connector.di.AuthProvider
import dagger.Component
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [AppRouterProvider::class, AuthProvider::class])
internal interface MainActivityComponent : AppRouterProvider, AuthProvider {
    fun inject(mainActivity: MainActivity)
}

internal fun initMainActivityComponent(
        appProvider: ApplicationProvider
): MainActivityComponent {
    return DaggerMainActivityComponent.builder()
            .authProvider(appProvider)
            .appRouterProvider(appProvider)
            .build()
}

@Scope
annotation class ActivityScope