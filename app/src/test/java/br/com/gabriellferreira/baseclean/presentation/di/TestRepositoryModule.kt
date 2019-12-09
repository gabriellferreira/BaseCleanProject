package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.data.repository.NewsDataRepository
import br.com.gabriellferreira.baseclean.domain.repository.NewsRepository
import com.nhaarman.mockitokotlin2.mock

class TestRepositoryModule : RepositoryModule() {

    override fun provideNewsRepository(repository: NewsDataRepository): NewsRepository = mock()
}