package br.com.gabrielferreira.baseclean.domain.repository

import br.com.gabrielferreira.baseclean.domain.model.News
import io.reactivex.Observable

interface NewsRepository {
    fun fetchLatestNews(): Observable<News>
}