package br.com.gabrielferreira.baseclean.presentation.view

import br.com.gabrielferreira.baseclean.presentation.model.NewsViewModel

interface NewsContract {

    interface View : BaseContract.View {
        fun initViews()

        fun bindToolbar()

        fun showLoading()

        fun hideLoading()

        fun showError()

        fun hideError()

        fun showContent()

        fun hideContent()

        fun onRefreshFinished()

        fun addNews(news: NewsViewModel)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onInitialize()

        fun refreshNews()

        fun onLoadFinished()

        fun onLoadError()

        fun onNewsReceived(news: NewsViewModel)
    }
}
