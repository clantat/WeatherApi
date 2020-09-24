package com.clantat.test.data.retrofit

import io.reactivex.rxjava3.core.Single

class WeatherGismeteoApi(private val gismeteoApi: GismeteoApi, private val apiKey: String) : WeatherReceiver {
    override fun getWeatherResponse(): Single<WeatherMainResponse> {
        return gismeteoApi.searchRX(apiKey)
            .map { weatherResponse ->
                return@map weatherResponse.list[0].main
            }
    }
}