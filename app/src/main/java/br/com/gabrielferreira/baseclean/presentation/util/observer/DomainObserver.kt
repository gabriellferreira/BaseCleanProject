package br.com.gabrielferreira.baseclean.presentation.util.observer

import android.support.annotation.CallSuper
import android.util.Log
import br.com.gabrielferreira.baseclean.presentation.util.extension.TAG
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DomainObserver<T>(private val pendingDisposables: CompositeDisposable) : Observer<T> {

    @CallSuper
    final override fun onSubscribe(d: Disposable) {
        pendingDisposables.add(d)
    }

    override fun onComplete() = Unit

    override fun onNext(item: T) = Unit

    override fun onError(e: Throwable) {
        Log.e(TAG, "General error while loading items from source observable")
    }

}