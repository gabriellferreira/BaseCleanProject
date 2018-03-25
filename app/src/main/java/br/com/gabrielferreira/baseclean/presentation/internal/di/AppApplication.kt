package br.com.gabrielferreira.baseclean.presentation.internal.di

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

open class AppApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: AppApplication private set
        lateinit var applicationComponent: AppComponent
    }

    init {
        instance = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                .apply { inject(this@AppApplication) }
    }
}
