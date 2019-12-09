package br.com.gabriellferreira.baseclean.data.repository

import br.com.gabriellferreira.baseclean.data.model.NewsData
import br.com.gabriellferreira.baseclean.data.network.api.NewsApi
import br.com.gabriellferreira.baseclean.data.storage.SessionPreferences
import br.com.gabriellferreira.baseclean.domain.repository.NewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsApi: NewsApi,
                                             private val storage: SessionPreferences) : NewsRepository {

    override fun fetchMostPopularNews(period: Int): Observable<NewsData> {
        val news = newsApi.getMostPopularNews(period)
        val load = storage.loadNewsData()
        return Observable.merge<NewsData>(news, load)
                .distinct {
                    it.id
                }
                .doOnNext {
                    storage.saveNewsData(it)
                }
    }

}