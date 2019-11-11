package br.com.gabriellferreira.baseclean.presentation.view.presenter

import br.com.gabriellferreira.baseclean.presentation.view.SplashContract
import javax.inject.Inject

class SplashPresenter @Inject constructor() : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun onInitialize() {
        view?.redirectMain()
    }
}
