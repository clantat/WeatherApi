package com.clantat.test.data.provider

import com.clantat.test.data.retrofit.WeatherReceiver
import com.clantat.test.domain.entities.WeatherEntity
import javax.inject.Inject

class WeatherEntityProviderImpl @Inject constructor(private val weatherReceiver: WeatherReceiver) :
    WeatherEntityProvider {
    override suspend fun getWeatherEntity(): WeatherEntity {
        return WeatherEntity(
            weatherReceiver.getWeatherResponse()?.temp ?: "Ошибка",
            weatherReceiver.getWeatherResponse()?.humidity ?: "Ошибка"
        )
    }
}