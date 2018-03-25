package br.com.gabrielferreira.baseclean.data.network.service

import br.com.gabrielferreira.baseclean.data.model.NewsData
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsService {

    @GET("/mostemailed/World/7")
    fun getLatestNews(): Observable<NewsData>
}