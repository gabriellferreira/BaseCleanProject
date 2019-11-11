package br.com.gabriellferreira.baseclean.presentation.internal.di

import br.com.gabriellferreira.baseclean.presentation.internal.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, RepositoryModules::class])
interface AppComponent {

    fun newControllerComponent(controllerModule: ControllerModule): ControllerComponent

    fun newServiceComponent(seviceModule: ServiceModule): ServiceComponent
}