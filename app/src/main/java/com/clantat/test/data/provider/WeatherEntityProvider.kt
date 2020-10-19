package com.clantat.test.data.provider

import com.clantat.test.domain.entities.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherEntityProvider {
    suspend fun getWeatherEntity(): WeatherEntity
}