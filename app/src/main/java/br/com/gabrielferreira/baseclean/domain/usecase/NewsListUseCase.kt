package br.com.gabrielferreira.baseclean.domain.usecase

import br.com.gabrielferreira.baseclean.domain.repository.NewsRepository
import br.com.gabrielferreira.baseclean.presentation.model.NewsListViewModel
import br.com.gabrielferreira.baseclean.presentation.observable.NewsListViewModelObserver
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleSource
import java.util.*
import javax.inject.Inject

class NewsListUseCase @Inject constructor(private val newsRepository: NewsRepository) : BaseUseCase() {

    fun fetchLatestNews(section: String, timePeriod: Int, observer: NewsListViewModelObserver) {
        newsRepository.fetchLatestNews()
                .flatMap { newsList ->
                    Single.create<NewsListViewModel> {
                        NewsListViewModel(newsList = newsList)
                    }
                }
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler)
                .subscribe(observer)
    }
}