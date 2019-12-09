package br.com.gabriellferreira.baseclean.presentation.di

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import br.com.gabriellferreira.baseclean.BuildConfig
import br.com.gabriellferreira.baseclean.data.storage.AppPreferences
import br.com.gabriellferreira.baseclean.data.storage.AppPreferencesStorage
import br.com.gabriellferreira.baseclean.data.storage.SessionPreferences
import br.com.gabriellferreira.baseclean.data.storage.SessionPreferencesStorage
import br.com.gabriellferreira.baseclean.presentation.util.connection.DefaultInternetConnectionVerifier
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier
import dagger.Module
import dagger.Provides

@Module
open class AppModule(private val appApplication: AppApplication) {

    @Provides
    open fun provideApplicationContext(): Context = appApplication

    @Provides
    open fun provideResources(context: Context): Resources = context.resources

    @Provides
    open fun provideSessionPreferences(context: Context): SessionPreferences = SessionPreferencesStorage(context)

    @Provides
    open fun provideAppPreferences(context: Context): AppPreferences = AppPreferencesStorage(context)

    @Provides
    open fun provideInternetConnectionVerifier(context: Context): InternetConnectionVerifier = DefaultInternetConnectionVerifier(context)
}