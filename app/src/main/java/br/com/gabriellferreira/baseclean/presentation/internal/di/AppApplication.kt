package br.com.gabriellferreira.baseclean.presentation.internal.di

import android.app.Application
import br.com.gabriellferreira.baseclean.BuildConfig
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

open class AppApplication : Application() {

    companion object {
        lateinit var applicationComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
        initFabric()
    }

    private fun initInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getApplicationComponent(): AppComponent {
        return applicationComponent
    }

    private fun initFabric() {
        if (!BuildConfig.DEBUG) {
            Fabric.with(this, Crashlytics())
        }
    }
}
