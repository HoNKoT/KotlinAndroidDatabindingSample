package jp.chau2chaun2.kotlindatabindingsample.net

import com.google.gson.GsonBuilder
import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit



class ApiService {

    val service: IApiService = create(IApiService::class.java)

    lateinit var retrofit: Retrofit

    val httpBuilder: OkHttpClient.Builder get() {
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val original = chain.request()

                    //header設定
                    val request = original.newBuilder()
                            .header("Accept", "application/json")
                            .method(original.method(), original.body())
                            .build()

                    return@Interceptor chain.proceed(request)
                })
                .readTimeout(30, TimeUnit.SECONDS)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)

        return httpClient
    }

    fun <S> create(serviceClass: Class<S>): S {
        val gson = GsonBuilder()
                .serializeNulls()
                .create()

        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://randomuser.me/")
                .client(httpBuilder.build())
                .build()

        return retrofit.create(serviceClass)
    }
}

interface IApiService {
    @GET("api")
    fun apiDemo(): Call<RandomUser>
}
