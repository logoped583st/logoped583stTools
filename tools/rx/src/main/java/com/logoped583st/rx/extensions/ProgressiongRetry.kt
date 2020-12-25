package com.logoped583st.rx.extensions

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

fun <T> Single<T>.progressionRetry(
        minDelay: Double = 5.0,
        retryFactor: Double = 2.0): Single<T> {

    var lastDelay = minDelay

    return retryWhen { errors ->
        errors.switchMap {
            Flowable.timer(lastDelay.toLong(), TimeUnit.SECONDS)
        }
    }.flatMap {
        lastDelay *= retryFactor
        this
    }
}