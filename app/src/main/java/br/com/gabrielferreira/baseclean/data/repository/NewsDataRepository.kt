package br.com.gabrielferreira.baseclean.data.repository

import br.com.gabrielferreira.baseclean.data.mapper.NewsMapper
import br.com.gabrielferreira.baseclean.data.network.api.NewsApi
import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsApi: NewsApi,
                                             private val newsMapper: NewsMapper) : NewsRepository {

    override fun fetchLatestNews(): Single<List<News>> =
            newsApi.getLatestNews().map { it.results?.map { newsMapper.map(it) } }
}