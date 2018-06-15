package br.com.gabrielferreira.baseclean.presentation.internal.di

import br.com.gabrielferreira.baseclean.data.repository.NewsDataRepository
import br.com.gabrielferreira.baseclean.domain.repository.NewsRepository
import br.com.gabrielferreira.baseclean.presentation.internal.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModules {

    @Provides
    @ApplicationScope
    fun provideNewsRepository(repository: NewsDataRepository): NewsRepository = repository
}