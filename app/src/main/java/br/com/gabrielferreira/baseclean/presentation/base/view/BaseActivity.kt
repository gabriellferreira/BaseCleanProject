package br.com.gabrielferreira.baseclean.presentation.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import br.com.gabrielferreira.baseclean.presentation.base.BaseContract

abstract class BaseActivity<T, in V> : AppCompatActivity(), BaseContract.View where T : BaseContract.Presenter<V>, V : BaseContract.View {

    protected var presenter: T? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }

    protected abstract fun createPresenter(): T

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = this.createPresenter()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
