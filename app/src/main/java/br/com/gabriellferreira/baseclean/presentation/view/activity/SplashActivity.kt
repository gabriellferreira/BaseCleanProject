package br.com.gabriellferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.gabriellferreira.baseclean.R
import br.com.gabriellferreira.baseclean.presentation.view.SplashContract

class SplashActivity : BaseActivity<SplashContract.Presenter, SplashContract.View>(),
        SplashContract.View {

    override fun createPresenter(): SplashContract.Presenter {
        getControllerComponent().inject(this)
        return getControllerComponent().splashPresenter()
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
