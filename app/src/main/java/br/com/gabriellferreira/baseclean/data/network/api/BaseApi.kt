package br.com.gabriellferreira.baseclean.data.network.api

import com.google.gson.GsonBuilder
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Interceptor.Companion.invoke
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

open class BaseApi @Inject constructor() {

    companion object {
        private val API_TIMEOUT = 30
        //TODO extract to external buildconfig
        private val API_KEY = "OBDqH5MnfSyCxkGbJYa1l9S9aRflJZfb"
    }

    fun build(timeout: Int = API_TIMEOUT): Retrofit {

        //TODO extract to external buildconfig
        val baseUrl = "https://api.nytimes.com/"

        val builder = OkHttpClient.Builder()
                .addInterceptor(generalInterceptor())
                .addInterceptor(logInterceptor())

        val clientBuilder = builder
                .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
                .connectTimeout(timeout.toLong(), TimeUnit.SECONDS)

        val client = clientBuilder.build()
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))

        return retrofitBuilder.build()
    }

    private fun generalInterceptor(): Interceptor =
            invoke { chain ->
                val original = chain.request()

                val originalHttpUrl = original.url

                val url: HttpUrl = originalHttpUrl.newBuilder()
                        .addQueryParameter("api-key", API_KEY)
                        .build()

                val builder = original.newBuilder()
                        .url(url)
                        .header("Content-Type", "application/json")
                        .method(original.method, original.body)

                val request = builder.build()
                chain.proceed(request)
            }

    private fun logInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}