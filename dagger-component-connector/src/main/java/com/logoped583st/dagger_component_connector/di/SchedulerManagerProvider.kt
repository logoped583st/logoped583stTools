package com.logoped583st.dagger_component_connector.di

import io.reactivex.rxjava3.core.Scheduler

fun interface SchedulerManagerProvider {
    fun provideSchedulerManager(): SchedulerManager
}

interface SchedulerManager {

    val main: Scheduler

    val io: Scheduler

    val computation: Scheduler

    val newThread: Scheduler
}