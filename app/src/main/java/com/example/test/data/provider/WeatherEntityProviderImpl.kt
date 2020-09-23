package com.example.test.data.provider

import com.example.test.data.retrofit.WeatherReceiver
import com.example.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherEntityProviderImpl @Inject constructor(private val weatherReceiver: WeatherReceiver) :
    WeatherEntityProvider {
    override fun getWeatherEntity(): Single<WeatherEntity> {
        return weatherReceiver.getWeatherResponse()
            .map { response ->
                return@map WeatherEntity(response.temp, response.humidity)
            }
    }
}