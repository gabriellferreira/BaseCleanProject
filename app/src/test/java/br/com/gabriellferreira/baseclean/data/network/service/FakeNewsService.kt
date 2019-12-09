package br.com.gabriellferreira.baseclean.data.network.service

import br.com.gabriellferreira.baseclean.data.model.NYTimesResultData
import io.reactivex.Observable

class FakeNewsService : NewsService {

    private val nyTimesData = NYTimesResultData()

    override fun getMostPopularNews(period: Int): Observable<NYTimesResultData> =
            Observable.just(nyTimesData)
}