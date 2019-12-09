package br.com.gabriellferreira.baseclean.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.gabriellferreira.baseclean.R
import br.com.gabriellferreira.baseclean.domain.model.News
import br.com.gabriellferreira.baseclean.presentation.util.extension.hide
import br.com.gabriellferreira.baseclean.presentation.util.extension.show
import br.com.gabriellferreira.baseclean.presentation.view.NewsListContract
import br.com.gabriellferreira.baseclean.presentation.view.adapter.NewsAdapter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.include_toolbar.*

class NewsActivity : BaseActivity<NewsListContract.Presenter, NewsListContract.View>(),
        NewsListContract.View {

    private val newsListAdapter by lazy { NewsAdapter() }
    private var newsClicksDisposable: Disposable? = null

    override fun createPresenter(): NewsListContract.Presenter {
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
            presenter?.loadMostPopularNews()
        }
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setupNewsRecycler() {
        news_recycler?.layoutManager = LinearLayoutManager(this)
        news_recycler?.adapter = newsListAdapter
        newsClicksDisposable = newsListAdapter.onItemClickSubject.subscribe {
            presenter?.onNewsClicked(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.news_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        presenter?.onOptionItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    override fun addNews(news: News) {
        newsListAdapter.add(news)
    }

    override fun clearAdapter() {
        newsListAdapter.clear()
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

    override fun showEmptyView() {
        news_empty_card?.show()
    }

    override fun hideEmptyView() {
        news_empty_card?.hide()
    }

    override fun onRefreshFinished() {
        news_swipe?.isRefreshing = false
    }

    override fun redirectWeb(url: String) {
        // TODO - replace by Chrome tabs
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}