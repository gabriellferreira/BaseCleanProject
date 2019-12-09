package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.presentation.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, RepositoryModule::class])
interface AppComponent {

    fun newControllerComponent(controllerModule: ControllerModule): ControllerComponent

    fun newServiceComponent(seviceModule: ServiceModule): ServiceComponent
}