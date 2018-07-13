package br.com.gabrielferreira.baseclean.presentation.model

import br.com.gabrielferreira.baseclean.domain.model.News

class NewsListViewModel(val newsList: List<News>, val premium: Boolean = false)