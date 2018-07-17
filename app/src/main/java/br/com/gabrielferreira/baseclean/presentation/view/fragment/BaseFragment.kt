package br.com.gabrielferreira.baseclean.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.internal.di.ControllerComponent
import br.com.gabrielferreira.baseclean.presentation.internal.di.ControllerModule
import br.com.gabrielferreira.baseclean.presentation.view.BaseContract

abstract class BaseFragment<T, in V> : Fragment(), BaseContract.View where T : BaseContract.Presenter<V>, V : BaseContract.View {

    private var mControllerComponent: ControllerComponent? = null

    protected var presenter: T? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }

    protected abstract fun createPresenter(): T

    @Suppress("UNCHECKED_CAST", "TooGenericExceptionThrown")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = this.createPresenter()
        try {
            presenter?.attachView(this as V)
        } catch (e: ClassCastException) {
            throw RuntimeException("Type V must be the same type of this class", e)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
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