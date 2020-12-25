package com.logoped583st.rx.extensions

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun <T> Observable<T>.longPolling(
        delay: Long = 10,
        timeUnit: TimeUnit = TimeUnit.SECONDS
): Observable<T> {
    return repeatWhen {
        it.concatMap { Observable.timer(delay, timeUnit) }
    }
}