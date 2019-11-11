package br.com.gabriellferreira.baseclean.domain.repository

import br.com.gabriellferreira.baseclean.domain.model.News
import io.reactivex.Single

interface NewsRepository {
    fun fetchLatestNews(): Single<List<News>>
}