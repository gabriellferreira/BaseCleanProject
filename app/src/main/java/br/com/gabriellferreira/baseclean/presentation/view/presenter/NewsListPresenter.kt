package br.com.gabriellferreira.baseclean.presentation.view.presenter

import android.view.MenuItem
import br.com.gabriellferreira.baseclean.R
import br.com.gabriellferreira.baseclean.domain.model.News
import br.com.gabriellferreira.baseclean.domain.usecase.NewsListUseCase
import br.com.gabriellferreira.baseclean.presentation.view.NewsListContract
import br.com.gabriellferreira.baseclean.presentation.view.NewsListContract.TimePeriod
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewsListPresenter @Inject constructor(private val latestNewsListUseCase: NewsListUseCase) :
        BasePresenter<NewsListContract.View>(), NewsListContract.Presenter {

    private var selectedTimePeriod = TimePeriod.ONE_DAY

    override fun onInitialize() {
        view?.initViews()
        view?.setupToolbar()
        loadMostPopularNews()
    }

    override fun onOptionItemSelected(item: MenuItem) {
        if (item.groupId != R.id.group_time_period) {
            return
        }
        when (item.itemId) {
            R.id.action_show_1_day -> {
                selectedTimePeriod = TimePeriod.ONE_DAY
                loadMostPopularNews()
            }
            R.id.action_show_7_days -> {
                selectedTimePeriod = TimePeriod.SEVEN_DAYS
                loadMostPopularNews()
            }
            R.id.action_show_30_days -> {
                selectedTimePeriod = TimePeriod.THIRTY_DAYS
                loadMostPopularNews()
            }
        }
        item.isChecked = true
    }

    override fun loadMostPopularNews() {
        latestNewsListUseCase.fetchMostPopularNews(selectedTimePeriod.days, object : Observer<News> {
            var numElements = 0
            override fun onComplete() {
                if (numElements != 0) {
                    view?.showContent()
                } else {
                    view?.showEmptyView()
                }
                view?.hideLoading()
                view?.onRefreshFinished()
            }

            override fun onNext(t: News) {
                view?.addNews(t)
                numElements++
            }

            override fun onSubscribe(d: Disposable) {
                numElements = 0
                view?.hideContent()
                view?.showLoading()
                view?.hideError()
                view?.clearAdapter()
                view?.hideEmptyView()
            }

            override fun onError(e: Throwable) {
                view?.hideContent()
                view?.hideLoading()
                view?.showError()
                view?.onRefreshFinished()
            }
        })
    }

    override fun onNewsClicked(news: News) {
        view?.redirectWeb(news.url)
    }
}