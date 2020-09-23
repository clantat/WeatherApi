package com.example.test.data.repositories

import com.example.test.data.provider.WeatherEntityProvider
import com.example.test.domain.entities.WeatherEntity
import com.example.test.domain.repositories.WeatherRepository
import io.reactivex.rxjava3.core.Single

class WeatherGateway(private val weatherEntityProvider: WeatherEntityProvider) : WeatherRepository {
    override fun getWeatherEntity(): Single<WeatherEntity> {
        return weatherEntityProvider.getWeatherEntity()
    }

}