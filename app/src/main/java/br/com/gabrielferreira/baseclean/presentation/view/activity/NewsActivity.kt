package br.com.gabrielferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.presentation.util.extension.hide
import br.com.gabrielferreira.baseclean.presentation.util.extension.show
import br.com.gabrielferreira.baseclean.presentation.util.view.BasePaddingItemDecoration
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import br.com.gabrielferreira.baseclean.presentation.view.adapter.NewsAdapter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity<NewsContract.Presenter, NewsContract.View>(),
        NewsContract.View {

    private val newsListAdapter by lazy { NewsAdapter() }
    private var newsClicksDisposable: Disposable? = null

    override fun createPresenter(): NewsContract.Presenter {
        getControllerComponent().inject(this)
        return getControllerComponent().newsPresenter()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, NewsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        initToolbar(getString(R.string.news_title))
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
        news_recycler?.layoutManager = LinearLayoutManager(this)
        resources?.let {
            news_recycler?.addItemDecoration(BasePaddingItemDecoration(R.dimen.news_list_recycler_padding, resources, true, false))
            news_recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }
        news_recycler?.adapter = newsListAdapter
        newsClicksDisposable = newsListAdapter.onItemClickSubject.subscribe {
            presenter?.onNewsClicked(it)
        }
    }

    override fun addNews(news: News) {
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

    override fun redirectWeb(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}