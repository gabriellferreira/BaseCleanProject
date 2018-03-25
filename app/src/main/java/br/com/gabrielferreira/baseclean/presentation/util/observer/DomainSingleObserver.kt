package br.com.gabrielferreira.baseclean.presentation.util.observer

import android.support.annotation.CallSuper
import android.util.Log
import br.com.gabrielferreira.baseclean.presentation.util.extension.TAG
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DomainSingleObserver<T> (private val pendingDisposables: CompositeDisposable) : SingleObserver<T> {

    @CallSuper
    final override fun onSubscribe(d: Disposable) {
        pendingDisposables.add(d)
    }

    override fun onSuccess(item: T) = Unit

    override fun onError(e: Throwable) {
        Log.e(TAG, "General error while loading items from source observable")
    }
}