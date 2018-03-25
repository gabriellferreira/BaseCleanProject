package br.com.gabrielferreira.baseclean.data.network.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class BaseApi {

    private val API_TIMEOUT = 30

    fun build(timeout: Int = API_TIMEOUT) : Retrofit{

        val baseUrl = ""

        val builder = OkHttpClient.Builder()
                .addInterceptor(generalInterceptor())

        val clientBuilder = builder
                .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
                .connectTimeout(timeout.toLong(), TimeUnit.SECONDS)

        val client = clientBuilder.build()
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)

        return retrofitBuilder.build()
    }

    private fun generalInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()

            val builder = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body())

            val request = builder.build()
            chain.proceed(request)
        }
    }
}