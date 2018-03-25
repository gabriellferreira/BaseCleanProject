package br.com.gabrielferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.view.MainContract

class MainActivity : BaseActivity<MainContract.Presenter, MainContract.View>(),
        MainContract.View {

    override fun createPresenter(): MainContract.Presenter {
        AppApplication.applicationComponent.inject(this)
        return AppApplication.applicationComponent.mainPresenter()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter?.onInitialize()
    }
}
