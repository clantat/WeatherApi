package com.example.test

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GismeteoApiService {
    @GET("data/2.5/forecast?q=izhevsk,ru&appid=8364d75b7c2dcf33ee2225f9d89a7286&lang=ru&units=metric")
    fun searchRX(): Observable<WeatherResponse>

    @GET("data/2.5/forecast?q=izhevsk,ru&appid=8364d75b7c2dcf33ee2225f9d89a7286&lang=ru&units=metric")
    fun searchCoroutine(): Deferred<WeatherResponse>

    companion object Factory {
        fun createRX(): GismeteoApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder().addInterceptor(interceptor)
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/")
                .build()
            return retrofit.create(GismeteoApiService::class.java)
        }

        fun createCoroutines(): GismeteoApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder().addInterceptor(interceptor)
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/")
                .build()
            return retrofit.create(GismeteoApiService::class.java)
        }

    }
}