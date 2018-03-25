package br.com.gabrielferreira.baseclean.presentation.splash.presenter

import br.com.gabrielferreira.baseclean.presentation.base.presenter.BasePresenter
import br.com.gabrielferreira.baseclean.presentation.splash.SplashContract
import javax.inject.Inject

class SplashPresenter @Inject constructor() : BasePresenter<SplashContract.View>(),
        SplashContract.Presenter
