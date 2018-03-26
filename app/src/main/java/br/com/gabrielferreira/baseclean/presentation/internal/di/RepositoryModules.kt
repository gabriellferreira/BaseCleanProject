package br.com.gabrielferreira.baseclean.presentation.internal.di

import br.com.gabrielferreira.baseclean.data.repository.NewsDataRepository
import br.com.gabrielferreira.baseclean.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModules {

    @Provides
    fun provideNewsRepository(repository: NewsDataRepository): NewsRepository = repository
}