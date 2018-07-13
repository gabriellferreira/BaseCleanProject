package br.com.gabrielferreira.baseclean.presentation.view

import br.com.gabrielferreira.baseclean.domain.model.News

interface NewsContract {

    interface View : BaseContract.View {
        fun initViews()

        fun showLoading()

        fun hideLoading()

        fun showError()

        fun hideError()

        fun showContent()

        fun hideContent()

        fun onRefreshFinished()

        fun addNews(news: News)

        fun redirectWeb(url: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onInitialize()

        fun refreshNews()

        fun onLoadFinished()

        fun onLoadError()

        fun onNewsClicked(news: News)
    }
}
