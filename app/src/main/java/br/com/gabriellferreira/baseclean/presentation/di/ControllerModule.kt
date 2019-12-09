package br.com.gabriellferreira.baseclean.presentation.di

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import br.com.gabriellferreira.baseclean.presentation.di.scope.ControllerScope
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