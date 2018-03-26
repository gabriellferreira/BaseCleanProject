package br.com.gabrielferreira.baseclean.data.repository

import br.com.gabrielferreira.baseclean.data.mapper.NewsListDomainMapper
import br.com.gabrielferreira.baseclean.data.network.api.NewsApi
import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.domain.repository.NewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsApi: NewsApi,
                                             private val newsListDomainMapper: NewsListDomainMapper) : NewsRepository {

    override fun fetchLatestNews(): Observable<List<News>> =
            newsApi.getLatestNews().map { newsListDomainMapper.map(it) }
}