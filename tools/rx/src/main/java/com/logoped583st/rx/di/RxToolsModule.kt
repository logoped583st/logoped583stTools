package com.logoped583st.rx.di

import com.logoped583st.rx.SchedulerManager
import com.logoped583st.rx.SchedulerManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RxToolsModule {

    @Binds
    @Singleton
    fun bindSchedulerManager(schedulerManager: SchedulerManagerImpl): SchedulerManager
}