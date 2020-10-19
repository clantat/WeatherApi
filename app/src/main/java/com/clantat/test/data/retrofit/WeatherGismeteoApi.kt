package com.clantat.test.data.retrofit

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherGismeteoApi(private val gismeteoApi: GismeteoApi, private val apiKey: String) :
    WeatherReceiver {
    override suspend fun getWeatherResponse(): WeatherMainResponse {
        return gismeteoApi.searchCoroutine(apiKey).list[0].main
    }
}