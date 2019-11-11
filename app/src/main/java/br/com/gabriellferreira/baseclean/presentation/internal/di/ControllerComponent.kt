package br.com.gabriellferreira.baseclean.presentation.internal.di

import br.com.gabriellferreira.baseclean.presentation.view.presenter.MainPresenter
import br.com.gabriellferreira.baseclean.presentation.view.presenter.NewsListPresenter
import br.com.gabriellferreira.baseclean.presentation.view.presenter.SplashPresenter
import br.com.gabriellferreira.baseclean.presentation.view.activity.MainActivity
import br.com.gabriellferreira.baseclean.presentation.view.activity.NewsActivity
import br.com.gabriellferreira.baseclean.presentation.view.activity.SplashActivity
import br.com.gabriellferreira.baseclean.presentation.internal.di.scope.ControllerScope
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [ControllerModule::class])
interface ControllerComponent {

    // Application
    fun inject(appApplication: AppApplication)

    // Presenter
    fun splashPresenter(): SplashPresenter

    fun mainPresenter(): MainPresenter

    fun newsPresenter(): NewsListPresenter

    // View
    fun inject(appApplication: SplashActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(newsActivity: NewsActivity)
}