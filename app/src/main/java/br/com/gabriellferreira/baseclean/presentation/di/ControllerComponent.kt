package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.presentation.di.scope.ControllerScope
import br.com.gabriellferreira.baseclean.presentation.view.activity.MainActivity
import br.com.gabriellferreira.baseclean.presentation.view.activity.NewsActivity
import br.com.gabriellferreira.baseclean.presentation.view.presenter.MainPresenter
import br.com.gabriellferreira.baseclean.presentation.view.presenter.NewsListPresenter
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [ControllerModule::class])
interface ControllerComponent {

    // Presenter
    fun mainPresenter(): MainPresenter

    fun newsPresenter(): NewsListPresenter

    // View
    fun inject(mainActivity: MainActivity)

    fun inject(newsActivity: NewsActivity)
}