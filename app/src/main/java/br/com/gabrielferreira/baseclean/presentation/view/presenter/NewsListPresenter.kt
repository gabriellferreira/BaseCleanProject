package br.com.gabrielferreira.baseclean.presentation.view.presenter

import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.domain.usecase.NewsListUseCase
import br.com.gabrielferreira.baseclean.presentation.view.observable.NewsListViewModelObserver
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import javax.inject.Inject

class NewsListPresenter @Inject constructor(private val latestNewsListUseCase: NewsListUseCase) :
        BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    override fun onInitialize() {
        view?.initViews()
        loadLatestNews()
    }

    private fun loadLatestNews() {
        view?.hideContent()
        view?.showLoading()
        view?.hideError()
        latestNewsListUseCase.fetchLatestNews("World", 1,
                NewsListViewModelObserver(view, this))
    }

    override fun refreshNews() {
        loadLatestNews()
    }

    override fun onLoadFinished() {
        view?.hideLoading()
        view?.onRefreshFinished()
        view?.showContent()
    }

    override fun onLoadError() {
        view?.showError()
        view?.hideLoading()
        view?.onRefreshFinished()
        view?.hideContent()
    }

    override fun onNewsClicked(news: News) {
        view?.redirectWeb(news.url)
    }
}