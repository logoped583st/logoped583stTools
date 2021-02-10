package com.logoped583st.rx.di

import com.logoped583st.dagger_component_connector.di.SchedulerManagerProvider
import dagger.Component

@Component(modules = [RxToolsModule::class])
internal interface RxToolsComponent : SchedulerManagerProvider

fun initRxTools(): SchedulerManagerProvider {
    return DaggerRxToolsComponent.builder()
            .build()
}