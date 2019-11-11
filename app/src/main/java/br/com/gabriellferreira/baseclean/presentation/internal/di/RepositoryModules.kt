package br.com.gabriellferreira.baseclean.presentation.internal.di

import br.com.gabriellferreira.baseclean.data.repository.NewsDataRepository
import br.com.gabriellferreira.baseclean.domain.repository.NewsRepository
import br.com.gabriellferreira.baseclean.presentation.internal.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModules {

    @Provides
    @ApplicationScope
    fun provideNewsRepository(repository: NewsDataRepository): NewsRepository = repository
}