package com.clantat.test.data.retrofit

data class WeatherMainResponse(val temp: String, val humidity: String)
data class WeatherListResponse(val main: WeatherMainResponse)
data class WeatherResponse(val list: List<WeatherListResponse>)

