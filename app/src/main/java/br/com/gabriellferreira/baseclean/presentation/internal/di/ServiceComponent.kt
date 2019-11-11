package br.com.gabriellferreira.baseclean.presentation.internal.di

import br.com.gabriellferreira.baseclean.presentation.internal.di.scope.ServiceScope
import dagger.Subcomponent

@ServiceScope
@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent