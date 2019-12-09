package br.com.gabriellferreira.baseclean.data.storage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import br.com.gabriellferreira.baseclean.BuildConfig
import br.com.gabriellferreira.baseclean.data.storage.AppPreferences.Companion.SHARED_FCM_TOKEN
import javax.inject.Inject

interface AppPreferences {

    companion object {
        const val SHARED_FCM_TOKEN = "SHARED_FCM_TOKEN"
    }

    fun getFCMToken(): String?
    fun setFCMToken(token: String)
}

class AppPreferencesStorage @Inject constructor(context: Context) : AppPreferences {

    private val storage: SharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)

    override fun getFCMToken(): String? =
            storage.getString(SHARED_FCM_TOKEN, "")

    @SuppressLint("ApplySharedPref")
    override fun setFCMToken(token: String) {
        storage.edit().putString(SHARED_FCM_TOKEN, token).commit()
    }
}

