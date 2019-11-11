package br.com.gabriellferreira.baseclean.presentation.view

interface BaseContract {

    interface View

    interface Presenter<in T : View> {

        fun attachView(view: T)

        fun detachView()

        fun onDestroy()
    }
}
