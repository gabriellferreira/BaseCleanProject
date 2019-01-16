package br.com.gabrielferreira.baseclean.presentation.view.presenter

import android.support.annotation.CallSuper
import br.com.gabrielferreira.baseclean.presentation.view.BaseContract
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : BaseContract.View> : BaseContract.Presenter<T> {

    protected val pendingDisposables = CompositeDisposable()

    protected var view: T? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }

    @CallSuper
    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    @CallSuper
    override fun onDestroy() = pendingDisposables.clear()

}
