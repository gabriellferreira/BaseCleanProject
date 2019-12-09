package br.com.gabriellferreira.baseclean.presentation.di

import android.app.Application

class AppApplication : Application() {

    companion object {
        lateinit var applicationComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    @Suppress("DEPRECATION")
    private fun initInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getApplicationComponent(): AppComponent {
        return applicationComponent
    }
}