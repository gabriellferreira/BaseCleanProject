package br.com.gabriellferreira.baseclean.domain.usecase

import br.com.gabriellferreira.baseclean.data.mapper.NewsMapper
import br.com.gabriellferreira.baseclean.domain.model.News
import br.com.gabriellferreira.baseclean.domain.repository.NewsRepository
import io.reactivex.Observer
import javax.inject.Inject

class NewsListUseCase @Inject constructor(private val newsRepository: NewsRepository,
                                          private val newsMapper: NewsMapper) : BaseUseCase() {

    fun fetchMostPopularNews(timePeriod: Int, observer: Observer<News>) {
        newsRepository.fetchMostPopularNews(timePeriod)
                .map {
                    newsMapper.map(it)
                }
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler)
                .subscribe(observer)
    }
}