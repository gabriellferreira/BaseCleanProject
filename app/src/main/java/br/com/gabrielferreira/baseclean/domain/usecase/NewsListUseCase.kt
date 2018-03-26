package br.com.gabrielferreira.baseclean.domain.usecase

import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.domain.repository.NewsRepository
import io.reactivex.Observer
import javax.inject.Inject

class NewsListUseCase @Inject constructor(private val newsRepository: NewsRepository): BaseUseCase() {

    //TODO - use header parameters
    fun fetchLatestNews(section: String, timePeriod: Int, observer: Observer<List<News>>) {
        newsRepository.fetchLatestNews()
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler)
                .subscribe(observer)
    }
}