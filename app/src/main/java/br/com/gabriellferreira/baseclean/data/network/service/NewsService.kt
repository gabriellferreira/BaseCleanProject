package br.com.gabriellferreira.baseclean.data.network.service

import br.com.gabriellferreira.baseclean.data.model.NYTimesResultData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {

    @GET("svc/mostpopular/v2/viewed/{period}.json")
    fun getMostPopularNews(@Path("period") period: Int): Observable<NYTimesResultData>
}