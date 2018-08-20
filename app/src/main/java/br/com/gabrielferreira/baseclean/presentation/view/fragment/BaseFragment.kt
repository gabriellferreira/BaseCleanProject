package br.com.gabrielferreira.baseclean.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.internal.di.ControllerComponent
import br.com.gabrielferreira.baseclean.presentation.internal.di.ControllerModule
import br.com.gabrielferreira.baseclean.presentation.view.BaseContract

abstract class BaseFragment<T, in V> : Fragment(),
        BaseContract.View where T : BaseContract.Presenter<V>, V : BaseContract.View {

    private var mControllerComponent: ControllerComponent? = null
    protected var presenter: T? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }

    protected abstract fun createPresenter(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        safeAttachView()
    }

    @Suppress("UNCHECKED_CAST", "TooGenericExceptionThrown")
    private fun safeAttachView() {
        try {
            presenter?.attachView(this as V)
        } catch (e: ClassCastException) {
            throw RuntimeException("Type V must be the same type of this class", e)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
        presenter?.detachView()
        presenter = null
    }

    protected fun getControllerComponent(): ControllerComponent {
        if (mControllerComponent == null) {
            mControllerComponent = AppApplication.applicationComponent
                    .newControllerComponent(ControllerModule(activity as AppCompatActivity))
        }
        return mControllerComponent!!
    }
}