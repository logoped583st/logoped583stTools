package com.bitbucket.main_screen.di

import com.logoped583st.dagger_component_connector.di.AppRouterProvider
import dagger.Component

@Component(modules = [MainActivityRouterModule::class])
interface MainActivityExportComponent : AppRouterProvider

fun initAppRouterProvider(): AppRouterProvider {
    return DaggerMainActivityExportComponent.builder()
            .build()
}
