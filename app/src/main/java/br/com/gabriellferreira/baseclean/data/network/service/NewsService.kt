package br.com.gabriellferreira.baseclean.data.network.service

import br.com.gabriellferreira.baseclean.data.model.NewsData
import br.com.gabriellferreira.baseclean.data.model.NewsListData
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import retrofit2.http.GET

interface NewsService {

    @GET("mostviewed/World/1.json")
    fun getLatestNews(): Single<NewsListData>
}