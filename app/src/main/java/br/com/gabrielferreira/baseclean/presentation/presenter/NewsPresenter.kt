package br.com.gabrielferreira.baseclean.presentation.presenter

import android.util.Log
import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.domain.usecase.NewsListUseCase
import br.com.gabrielferreira.baseclean.presentation.mapper.NewsViewMapper
import br.com.gabrielferreira.baseclean.presentation.model.NewsViewModel
import br.com.gabrielferreira.baseclean.presentation.util.extension.TAG
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val latestNewsListUseCase: NewsListUseCase,
                                        private val newsViewMapper: NewsViewMapper) :
        BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    override fun onInitialize() {
        view?.initViews()
        loadLatestNews()
    }

    private fun loadLatestNews() {
        view?.hideContent()
        view?.showLoading()
        view?.hideError()

        //TODO - convert to a external observable class
        latestNewsListUseCase.fetchLatestNews("World", 1, object : Observer<List<News>> {
            override fun onComplete() {
                view?.showContent()
                view?.hideLoading()
                view?.hideError()
                view?.onRefreshFinished()
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe")
            }

            override fun onNext(t: List<News>) {
                t.map { onNewsReceived(newsViewMapper.map(it))}
            }

            override fun onError(e: Throwable) {
                view?.hideContent()
                view?.hideLoading()
                view?.showError()
                view?.onRefreshFinished()
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

    override fun onNewsClicked(news: NewsViewModel) {
        view?.redirectWeb(news.url)
    }
}