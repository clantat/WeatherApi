package com.clantat.test.data.repositories

import com.clantat.test.data.provider.WeatherEntityProvider
import com.clantat.test.domain.entities.WeatherEntity
import com.clantat.test.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherGateway(private val weatherEntityProvider: WeatherEntityProvider) : WeatherRepository {
    override suspend fun getWeatherEntity(): WeatherEntity {
        return weatherEntityProvider.getWeatherEntity()
    }

}