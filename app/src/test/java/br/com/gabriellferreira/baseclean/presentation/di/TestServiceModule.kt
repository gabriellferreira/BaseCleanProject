package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.data.network.service.FakeNewsService
import br.com.gabriellferreira.baseclean.data.network.service.NewsService
import dagger.Module
import dagger.Provides

@Module
class TestServiceModule {

    @Provides
    fun provideFakeNewsService(): NewsService = FakeNewsService()
}
