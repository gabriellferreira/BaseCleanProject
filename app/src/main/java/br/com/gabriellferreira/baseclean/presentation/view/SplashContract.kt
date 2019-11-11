package br.com.gabriellferreira.baseclean.presentation.view

interface SplashContract {

    interface View : BaseContract.View {
        fun redirectMain()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onInitialize()
    }
}
