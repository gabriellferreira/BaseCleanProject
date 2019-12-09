package br.com.gabriellferreira.baseclean.presentation.di

import android.content.Context
import android.content.res.Resources
import br.com.gabriellferreira.baseclean.data.storage.AppPreferences
import br.com.gabriellferreira.baseclean.data.storage.FakeAppPreferencesStorage
import br.com.gabriellferreira.baseclean.data.storage.FakeSessionPreferencesStorage
import br.com.gabriellferreira.baseclean.data.storage.SessionPreferences
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier
import com.nhaarman.mockitokotlin2.mock

class TestAppModule(
        appApplication: AppApplication
) : AppModule(appApplication) {

    override fun provideApplicationContext(): Context = mock()

    override fun provideInternetConnectionVerifier(context: Context): InternetConnectionVerifier = mock()

    override fun provideResources(context: Context): Resources = mock()

    override fun provideSessionPreferences(context: Context): SessionPreferences = FakeSessionPreferencesStorage()

    override fun provideAppPreferences(context: Context): AppPreferences = FakeAppPreferencesStorage()
}