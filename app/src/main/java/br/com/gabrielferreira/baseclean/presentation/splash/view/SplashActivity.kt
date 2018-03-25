package br.com.gabrielferreira.baseclean.presentation.splash.view

import android.os.Bundle
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.presentation.base.view.BaseActivity
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.splash.SplashContract

class SplashActivity : BaseActivity<SplashContract.Presenter, SplashContract.View>(),
        SplashContract.View {

    override fun createPresenter(): SplashContract.Presenter {
        AppApplication.applicationComponent.inject(this)
        return AppApplication.applicationComponent.splashPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
