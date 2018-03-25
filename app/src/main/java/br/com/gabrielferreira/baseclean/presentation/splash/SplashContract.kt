package br.com.gabrielferreira.baseclean.presentation.splash

import br.com.gabrielferreira.baseclean.presentation.base.BaseContract

interface SplashContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
