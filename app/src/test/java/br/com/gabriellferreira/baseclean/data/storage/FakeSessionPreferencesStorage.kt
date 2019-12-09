package br.com.gabriellferreira.baseclean.data.storage

import br.com.gabriellferreira.baseclean.data.model.NewsData
import br.com.gabriellferreira.baseclean.data.model.NoDataException
import io.reactivex.Observable

class FakeSessionPreferencesStorage : SessionPreferences {

    private val map = mutableMapOf<String?, NewsData?>()

    override fun saveNewsData(data: NewsData) {
        map[data.id] = data
    }

    override fun loadNewsData(): Observable<NewsData> {
        val data = map.map { it.value }
        return if (data.isEmpty()) {
            Observable.fromIterable(data)
        } else {
            Observable.error(NoDataException())
        }
    }

    override fun clearData() {
        map.clear()
    }
}