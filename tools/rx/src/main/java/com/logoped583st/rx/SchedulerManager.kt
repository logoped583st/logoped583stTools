package com.logoped583st.rx

import com.logoped583st.dagger_component_connector.di.SchedulerManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

internal class SchedulerManagerImpl @Inject constructor() : SchedulerManager {
    override val main: Scheduler = AndroidSchedulers.mainThread()

    override val io: Scheduler = Schedulers.io()

    override val computation: Scheduler = Schedulers.computation()

    override val newThread: Scheduler = Schedulers.newThread()
}