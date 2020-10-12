package com.clantat.test.domain.interactors

import com.clantat.test.domain.entities.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherInteractor {
    suspend fun getWeatherEntity(): WeatherEntity
}