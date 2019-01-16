package br.com.gabrielferreira.baseclean.presentation.internal.di

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import br.com.gabrielferreira.baseclean.presentation.internal.di.scope.ControllerScope
import dagger.Module
import dagger.Provides

@Module
class ControllerModule(val mActivity: AppCompatActivity) {

    @Provides
    @ControllerScope
    fun context(): Context {
        return mActivity
    }

    @Provides
    @ControllerScope
    fun activity(): Activity {
        return mActivity
    }
}