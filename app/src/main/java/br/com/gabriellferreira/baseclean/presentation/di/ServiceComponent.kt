package br.com.gabriellferreira.baseclean.presentation.di

import br.com.gabriellferreira.baseclean.presentation.di.scope.ServiceScope
import dagger.Subcomponent

@ServiceScope
@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent