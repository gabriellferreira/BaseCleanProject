package br.com.gabrielferreira.baseclean.presentation.internal.di

import br.com.gabrielferreira.baseclean.presentation.splash.presenter.SplashPresenter
import br.com.gabrielferreira.baseclean.presentation.splash.view.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RepositoryModules::class)])
interface AppComponent {

    val appApplication: AppApplication

    // Application
    fun inject(appApplication: AppApplication)

    // Presenter
    fun splashPresenter(): SplashPresenter

    // View
    fun inject(appApplication: SplashActivity)
}