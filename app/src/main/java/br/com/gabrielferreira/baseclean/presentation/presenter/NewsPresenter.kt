package br.com.gabrielferreira.baseclean.presentation.presenter

import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.domain.usecase.NewsListUseCase
import br.com.gabrielferreira.baseclean.presentation.model.NewsViewModel
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewsPresenter @Inject constructor(val latestNewsListUseCase: NewsListUseCase) :
        BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    override fun onInitialize() {
        view?.bindToolbar()
        view?.initViews()
        loadLatestNews()
    }

    private fun loadLatestNews() {
        view?.hideContent()
        view?.showLoading()
        view?.hideError()

        latestNewsListUseCase.fetchLatestNews("World", 1, object : Observer<News>{
            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSubscribe(d: Disposable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(t: News) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(e: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
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
