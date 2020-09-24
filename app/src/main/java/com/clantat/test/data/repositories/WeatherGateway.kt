package com.clantat.test.data.repositories

import com.clantat.test.data.provider.WeatherEntityProvider
import com.clantat.test.domain.entities.WeatherEntity
import com.clantat.test.domain.repositories.WeatherRepository
import io.reactivex.rxjava3.core.Single

class WeatherGateway(private val weatherEntityProvider: WeatherEntityProvider) : WeatherRepository {
    override fun getWeatherEntity(): Single<WeatherEntity> {
        return weatherEntityProvider.getWeatherEntity()
    }

}