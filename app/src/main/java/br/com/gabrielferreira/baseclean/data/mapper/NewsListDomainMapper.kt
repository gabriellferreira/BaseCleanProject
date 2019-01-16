package br.com.gabrielferreira.baseclean.data.mapper

import br.com.gabrielferreira.baseclean.data.model.NewsListData
import br.com.gabrielferreira.baseclean.domain.model.News
import javax.inject.Inject

class NewsListDomainMapper @Inject constructor(private val newsDataMapper: NewsMapper) {

    fun map(newsListData: NewsListData): List<News>{
        val mutableList = mutableListOf<News>()
        newsListData.results?.map { mutableList.add(newsDataMapper.map(it)) }
        return mutableList
    }
}