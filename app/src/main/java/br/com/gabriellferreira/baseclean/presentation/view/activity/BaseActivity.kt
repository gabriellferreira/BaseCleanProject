package br.com.gabriellferreira.baseclean.presentation.view.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gabriellferreira.baseclean.presentation.di.AppApplication
import br.com.gabriellferreira.baseclean.presentation.di.ControllerComponent
import br.com.gabriellferreira.baseclean.presentation.di.ControllerModule
import br.com.gabriellferreira.baseclean.presentation.util.extension.hide
import br.com.gabriellferreira.baseclean.presentation.util.extension.show
import br.com.gabriellferreira.baseclean.presentation.view.BaseContract
import kotlinx.android.synthetic.main.include_toolbar.*

abstract class BaseActivity<T, in V> : AppCompatActivity(), BaseContract.View where T : BaseContract.Presenter<V>, V : BaseContract.View {

    private var mControllerComponent: ControllerComponent? = null

    protected var presenter: T? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }

    protected abstract fun createPresenter(): T

    @Suppress("UNCHECKED_CAST", "TooGenericExceptionThrown")
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

    protected fun initToolbar(title: String = "") {
        toolbar?.let {
            if (title.isNotEmpty()) {
                toolbar_title.show()
                toolbar_title.text = title
                toolbar.title = ""
            } else {
                toolbar_title.hide()
                toolbar.title = ""
            }
        }
    }

    protected fun getControllerComponent(): ControllerComponent {
        if (mControllerComponent == null) {
            mControllerComponent = (application as AppApplication).getApplicationComponent()
                    .newControllerComponent(ControllerModule(this))
        }
        return mControllerComponent!!
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
