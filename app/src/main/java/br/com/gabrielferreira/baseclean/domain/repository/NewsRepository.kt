package br.com.gabrielferreira.baseclean.domain.repository

import br.com.gabrielferreira.baseclean.domain.model.News
import io.reactivex.Single

interface NewsRepository {
    fun fetchLatestNews(): Single<List<News>>
}