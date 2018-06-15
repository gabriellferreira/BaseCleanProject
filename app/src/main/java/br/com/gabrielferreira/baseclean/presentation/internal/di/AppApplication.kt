package br.com.gabrielferreira.baseclean.presentation.internal.di

import android.app.Application

open class AppApplication : Application() {

    companion object {
        lateinit var applicationComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getApplicationComponent(): AppComponent {
        return applicationComponent
    }
}
