package br.com.gabrielferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.presentation.internal.di.AppApplication
import br.com.gabrielferreira.baseclean.presentation.model.NewsViewModel
import br.com.gabrielferreira.baseclean.presentation.util.extension.hide
import br.com.gabrielferreira.baseclean.presentation.util.extension.show
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import br.com.gabrielferreira.baseclean.presentation.view.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity<NewsContract.Presenter, NewsContract.View>(),
        NewsContract.View {

    private val newsListAdapter by lazy { NewsAdapter() }

    override fun createPresenter(): NewsContract.Presenter {
        AppApplication.applicationComponent.inject(this)
        return AppApplication.applicationComponent.newsPresenter()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, NewsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        presenter?.onInitialize()
    }

    override fun initViews() {
        initListeners()
        setupNewsRecycler()
    }

    private fun initListeners() {
        news_swipe?.isEnabled = false
        news_swipe?.setOnRefreshListener {
            presenter?.refreshNews()
        }
    }

    private fun setupNewsRecycler() {
        news_recycler?.setHasFixedSize(false)
        news_recycler?.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
        news_recycler?.adapter = newsListAdapter
    }

    override fun bindToolbar() {

    }

    override fun addNews(news: NewsViewModel) {
        newsListAdapter.add(news)
    }

    override fun showLoading() {
        news_swipe?.isEnabled = false
        news_progress?.show()
    }

    override fun hideLoading() {
        news_swipe?.isEnabled = true
        news_progress?.hide()
    }

    override fun showError() {
        news_error_card?.show()
    }

    override fun hideError() {
        news_error_card?.hide()
    }

    override fun showContent() {
        news_recycler?.show()
    }

    override fun hideContent() {
        news_recycler?.hide()
    }

    override fun onRefreshFinished() {
        news_swipe?.isRefreshing = false
    }
}