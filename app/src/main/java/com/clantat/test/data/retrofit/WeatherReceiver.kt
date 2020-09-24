package com.clantat.test.data.retrofit

import io.reactivex.rxjava3.core.Single

interface WeatherReceiver {
    fun getWeatherResponse(): Single<WeatherMainResponse>
}