package br.com.gabrielferreira.baseclean.presentation.base

interface BaseContract {

    interface View

    interface Presenter<in T : View> {

        fun attachView(view: T)

        fun detachView()

        fun onDestroy()
    }
}
