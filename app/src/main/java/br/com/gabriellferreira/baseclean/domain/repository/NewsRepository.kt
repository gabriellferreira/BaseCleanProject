package br.com.gabriellferreira.baseclean.domain.repository

import br.com.gabriellferreira.baseclean.data.model.NewsData
import io.reactivex.Observable

interface NewsRepository {
    fun fetchMostPopularNews(period: Int): Observable<NewsData>
}