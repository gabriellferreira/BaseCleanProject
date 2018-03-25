package br.com.gabrielferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.view.MainContract
import kotlinx.android.synthetic.main.activity_main.*

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
        initListeners()
    }

    private fun initListeners() {
        main_news_button?.setOnClickListener {
            presenter?.onNewsButtonClick()
        }
    }

    override fun redirectLatestNews() {
        startActivity(NewsActivity.createIntent(this))
    }
}