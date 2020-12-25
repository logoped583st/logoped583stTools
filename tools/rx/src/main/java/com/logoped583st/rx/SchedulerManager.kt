package com.logoped583st.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

interface SchedulerManager {

    val main: Scheduler

    val io: Scheduler

    val computation: Scheduler

    val newThread: Scheduler
}

class SchedulerManagerImpl @Inject constructor() : SchedulerManager {
    override val main: Scheduler = AndroidSchedulers.mainThread()

    override val io: Scheduler = Schedulers.io()

    override val computation: Scheduler = Schedulers.computation()

    override val newThread: Scheduler = Schedulers.newThread()
}