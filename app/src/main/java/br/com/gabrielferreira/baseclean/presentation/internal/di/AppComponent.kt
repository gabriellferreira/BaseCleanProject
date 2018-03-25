package br.com.gabrielferreira.baseclean.presentation.internal.di

import br.com.gabrielferreira.baseclean.presentation.presenter.MainPresenter
import br.com.gabrielferreira.baseclean.presentation.presenter.SplashPresenter
import br.com.gabrielferreira.baseclean.presentation.view.activity.MainActivity
import br.com.gabrielferreira.baseclean.presentation.view.activity.SplashActivity
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

    fun mainPresenter(): MainPresenter

    // View
    fun inject(appApplication: SplashActivity)

    fun inject(mainActivity: MainActivity)
}