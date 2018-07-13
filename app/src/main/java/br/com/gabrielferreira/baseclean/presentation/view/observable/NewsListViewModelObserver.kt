package br.com.gabrielferreira.baseclean.presentation.view.observable

import android.util.Log
import br.com.gabrielferreira.baseclean.presentation.view.model.NewsListViewModel
import br.com.gabrielferreira.baseclean.presentation.util.extension.TAG
import br.com.gabrielferreira.baseclean.presentation.view.NewsContract
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class NewsListViewModelObserver(val view: NewsContract.View?,
                                val presenter: NewsContract.Presenter) : SingleObserver<NewsListViewModel> {

    override fun onSuccess(t: NewsListViewModel) {
        t.newsList.map { view?.addNews(it) }
        view?.showContent()
        view?.hideLoading()
        view?.hideError()
        view?.onRefreshFinished()
    }

    override fun onSubscribe(d: Disposable) {
        Log.d(TAG, "onSubscribe")
    }

    override fun onError(e: Throwable) {
        view?.hideContent()
        view?.hideLoading()
        view?.showError()
        view?.onRefreshFinished()
    }
}