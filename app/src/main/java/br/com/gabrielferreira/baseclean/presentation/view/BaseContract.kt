package br.com.gabrielferreira.baseclean.presentation.view

interface BaseContract {

    interface View

    interface Presenter<in T : View> {

        fun attachView(view: T)

        fun detachView()

        fun onDestroy()
    }
}
