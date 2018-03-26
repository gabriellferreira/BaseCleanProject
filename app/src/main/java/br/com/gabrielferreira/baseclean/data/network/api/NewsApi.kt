package br.com.gabrielferreira.baseclean.data.network.api

import br.com.gabrielferreira.baseclean.data.model.NewsListData
import br.com.gabrielferreira.baseclean.data.network.service.NewsService
import io.reactivex.Observable
import javax.inject.Inject

class NewsApi @Inject constructor() : BaseApi() {

    private var newsService: NewsService

    init {
        val retrofit = build()
        newsService = retrofit.create(NewsService::class.java)
    }

    fun getLatestNews(): Observable<NewsListData> = newsService.getLatestNews()
}