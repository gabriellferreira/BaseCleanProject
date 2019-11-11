package br.com.gabriellferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.gabriellferreira.baseclean.R
import br.com.gabriellferreira.baseclean.presentation.view.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.Presenter, MainContract.View>(),
        MainContract.View {

    override fun createPresenter(): MainContract.Presenter {
        getControllerComponent().inject(this)
        return getControllerComponent().mainPresenter()
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
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