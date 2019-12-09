package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.data.repository.NewsDataRepository
import br.com.gabriellferreira.baseclean.domain.repository.NewsRepository
import br.com.gabriellferreira.baseclean.presentation.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
open class RepositoryModule {

    @Provides
    @ApplicationScope
    open fun provideNewsRepository(repository: NewsDataRepository): NewsRepository = repository
}