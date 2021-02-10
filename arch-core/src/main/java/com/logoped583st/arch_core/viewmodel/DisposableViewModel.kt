package com.logoped583st.arch_core.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class DisposableViewModel : ViewModel() {

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.addTo() {
        disposable.add(this)

        val a = (1 as Object)
    }


}