package com.logoped583st.rx.di

import com.logoped583st.dagger_component_connector.di.SchedulerManager
import com.logoped583st.rx.SchedulerManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RxToolsModule {

    @Binds
    fun bindSchedulerManager(schedulerManager: SchedulerManagerImpl): SchedulerManager
}