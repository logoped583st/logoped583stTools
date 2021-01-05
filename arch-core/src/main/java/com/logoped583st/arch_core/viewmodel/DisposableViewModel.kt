package com.logoped583st.arch_core.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class DisposableViewModel : ViewModel() {

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.addTo() {
        disposable.add(this)
    }
}