package br.com.gabrielferreira.baseclean.presentation.internal.di

import android.app.Application

open class AppApplication : Application() {

    companion object {
        lateinit var instance: AppApplication private set
        lateinit var applicationComponent: AppComponent
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                .apply { inject(this@AppApplication) }
    }
}
