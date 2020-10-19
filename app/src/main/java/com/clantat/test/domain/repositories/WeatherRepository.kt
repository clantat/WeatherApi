package com.clantat.test.domain.repositories

import com.clantat.test.domain.entities.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherEntity(): WeatherEntity
}