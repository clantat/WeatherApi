package com.example.test.data.retrofit

import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GismeteoApi {
    @GET("data/2.5/forecast?q=izhevsk,ru&lang=ru&units=metric")
    fun searchRX(
        @Query("appid") apiKey: String
    ): Single<WeatherResponse>

    @GET("data/2.5/forecast?q=izhevsk,ru&lang=ru&units=metric")
    fun searchCoroutine(
        @Query("appid") apiKey: String
    ): Deferred<WeatherResponse>
}