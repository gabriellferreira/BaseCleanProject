package br.com.gabrielferreira.baseclean.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import br.com.gabrielferreira.baseclean.presentation.view.BaseContract

abstract class BaseFragment<T, in V> : Fragment(), BaseContract.View where T : BaseContract.Presenter<V>, V : BaseContract.View {

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

    @Suppress("UNCHECKED_CAST")
    private fun safeAttachView() {
        try {
            presenter?.attachView(this as V)
        } catch (e: ClassCastException) {
            throw RuntimeException("Type V must be the same type of this class", e)
        }
    }

    private fun setupToolbar(toolbar: Toolbar) {
        activity?.let {
            if (it is AppCompatActivity) {
                it.setSupportActionBar(toolbar)

                it.supportActionBar?.let { actionBar ->
                    actionBar.title = toolbar.title
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (presenter != null) {
            presenter?.detachView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
}