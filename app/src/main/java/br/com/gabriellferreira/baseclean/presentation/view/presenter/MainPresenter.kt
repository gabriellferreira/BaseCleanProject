package br.com.gabriellferreira.baseclean.presentation.view.presenter

import br.com.gabriellferreira.baseclean.presentation.view.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun onNewsButtonClick() {
        view?.redirectLatestNews()
    }
}
