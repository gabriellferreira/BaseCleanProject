package br.com.gabriellferreira.baseclean.presentation.internal.di

import android.content.Context
import android.content.SharedPreferences
import br.com.gabriellferreira.baseclean.BuildConfig
import br.com.gabriellferreira.baseclean.presentation.util.connection.DefaultInternetConnectionVerifier
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appApplication: AppApplication) {

    @Provides
    fun provideApplicationContext(): Context = appApplication

    @Provides
    fun provideInternetConnectionVerifier(context: Context): InternetConnectionVerifier = DefaultInternetConnectionVerifier(context)

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
}