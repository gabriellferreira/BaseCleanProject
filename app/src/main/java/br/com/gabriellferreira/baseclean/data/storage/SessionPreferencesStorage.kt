package br.com.gabriellferreira.baseclean.data.storage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import br.com.gabriellferreira.baseclean.BuildConfig
import br.com.gabriellferreira.baseclean.data.model.NewsData
import br.com.gabriellferreira.baseclean.data.storage.SessionPreferences.Companion.SHARED_LATEST_NEWS
import br.com.gabriellferreira.baseclean.presentation.util.extension.fromJson
import com.google.gson.Gson
import io.reactivex.Observable
import javax.inject.Inject

interface SessionPreferences {

    companion object {
        const val SHARED_LATEST_NEWS = "SHARED_LATEST_NEWS"
    }

    fun saveNewsData(data: NewsData)
    fun loadNewsData(): Observable<NewsData>
    fun clearData()
}

// TODO - DISCLAIMER - implementation only with the purpose of testing, for production use a DB.

@SuppressLint("ApplySharedPref")
class SessionPreferencesStorage @Inject constructor(context: Context) : SessionPreferences {

    private val sessionStorage: SharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID + "session", Context.MODE_PRIVATE)

    private val map = mutableMapOf<String?, NewsData?>()

    override fun saveNewsData(data: NewsData) {
        val map = Gson().fromJson<MutableMap<String, NewsData>>(sessionStorage.getString(SHARED_LATEST_NEWS, ""))
                ?: mutableMapOf()
        data.id?.let {
            map[it] = data
        }
        sessionStorage.edit().putString(SHARED_LATEST_NEWS, Gson().toJson(map)).commit()
    }

    override fun loadNewsData(): Observable<NewsData> {
        val map = Gson().fromJson<MutableMap<String, NewsData>>(sessionStorage.getString(SHARED_LATEST_NEWS, ""))
                ?: mutableMapOf()
        val data = map.map { it.value }
        return Observable.fromIterable(data)
    }

    override fun clearData() {
        sessionStorage.edit().clear().commit()
    }
}

