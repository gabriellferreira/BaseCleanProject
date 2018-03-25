package br.com.gabrielferreira.baseclean.presentation.presenter

import br.com.gabrielferreira.baseclean.presentation.view.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun onInitialize() {

    }
}
