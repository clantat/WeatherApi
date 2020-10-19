package com.clantat.test.data.retrofit

interface WeatherReceiver {
    suspend fun getWeatherResponse(): WeatherMainResponse
}