package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.data.repository.NewsDataRepositoryTest
import br.com.gabriellferreira.baseclean.presentation.di.scope.ApplicationScope
import br.com.gabriellferreira.baseclean.presentation.view.presenter.NewsListPresenterTest
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, RepositoryModule::class, TestServiceModule::class])
interface TestAppComponent : AppComponent {

    fun inject(appApplication: NewsListPresenterTest)
    fun inject(appApplication: NewsDataRepositoryTest)
}