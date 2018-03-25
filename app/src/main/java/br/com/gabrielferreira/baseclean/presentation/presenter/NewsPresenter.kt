package br.com.gabrielferreira.baseclean.presentation.presenter

import br.com.gabrielferreira.baseclean.presentation.model.NewsViewModel
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    override fun onInitialize() {
        view?.bindToolbar()
        view?.initViews()
        loadLatestNews()
    }

    private fun loadLatestNews() {
        view?.hideContent()
        view?.showLoading()
        view?.hideError()

        // TODO call usecase
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

    override fun onNewsReceived(news: NewsViewModel) {
        view?.addNews(news)
    }
}
