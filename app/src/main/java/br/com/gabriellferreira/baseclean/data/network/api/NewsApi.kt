package br.com.gabriellferreira.baseclean.data.network.api

import br.com.gabriellferreira.baseclean.data.model.NewsData
import br.com.gabriellferreira.baseclean.data.network.service.NewsService
import io.reactivex.Observable
import javax.inject.Inject

class NewsApi @Inject constructor() : BaseApi() {

    private val newsService: NewsService

    init {
        val retrofit = build()
        newsService = retrofit.create(NewsService::class.java)
    }

    fun getMostPopularNews(period: Int): Observable<NewsData> =
            newsService.getMostPopularNews(period)
                    .flatMapIterable {
                        it.results
                    }.onErrorResumeNext(
                            Observable.empty<NewsData>()
                    )
}