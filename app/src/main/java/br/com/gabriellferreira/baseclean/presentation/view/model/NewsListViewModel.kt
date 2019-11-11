package br.com.gabriellferreira.baseclean.presentation.view.model

import br.com.gabriellferreira.baseclean.domain.model.News

class NewsListViewModel(val newsList: List<News>, val premium: Boolean = false)