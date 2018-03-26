package br.com.gabrielferreira.baseclean.data.mapper

import br.com.gabrielferreira.baseclean.data.model.NewsData
import br.com.gabrielferreira.baseclean.domain.model.News
import javax.inject.Inject

class NewsDomainMapper @Inject constructor() {

    fun map(newsData: NewsData) =
            News()
}