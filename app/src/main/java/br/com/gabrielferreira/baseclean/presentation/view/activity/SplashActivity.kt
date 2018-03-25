package br.com.gabrielferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.view.SplashContract

class SplashActivity : BaseActivity<SplashContract.Presenter, SplashContract.View>(),
        SplashContract.View {

    override fun createPresenter(): SplashContract.Presenter {
        AppApplication.applicationComponent.inject(this)
        return AppApplication.applicationComponent.splashPresenter()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, SplashActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter?.onInitialize()
    }

    override fun redirectMain() {
        startActivity(MainActivity.createIntent(this))
    }
}
