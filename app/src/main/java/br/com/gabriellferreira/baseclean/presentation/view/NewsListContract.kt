package br.com.gabriellferreira.baseclean.presentation.view

import android.view.MenuItem
import br.com.gabriellferreira.baseclean.domain.model.News

interface NewsListContract {

    interface View : BaseContract.View {
        fun initViews()
        fun setupToolbar()
        fun showLoading()
        fun hideLoading()
        fun showError()
        fun hideError()
        fun showContent()
        fun hideContent()
        fun onRefreshFinished()
        fun addNews(news: News)
        fun clearAdapter()
        fun redirectWeb(url: String)
        fun showEmptyView()
        fun hideEmptyView()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onInitialize()
        fun onNewsClicked(news: News)
        fun loadMostPopularNews()
        fun onOptionItemSelected(item: MenuItem)
    }

    @Suppress("MagicNumber")
    enum class TimePeriod(val days: Int) {
        ONE_DAY(1),
        SEVEN_DAYS(7),
        THIRTY_DAYS (30)
    }
}
