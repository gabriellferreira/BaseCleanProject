package br.com.gabrielferreira.baseclean.presentation.view

interface MainContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View> {
        fun onInitialize()
    }
}
