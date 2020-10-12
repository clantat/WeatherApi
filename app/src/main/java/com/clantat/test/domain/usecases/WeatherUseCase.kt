package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.WeatherEntity
import com.clantat.test.domain.interactors.WeatherInteractor
import com.clantat.test.domain.repositories.WeatherRepository

class WeatherUseCase(private val weatherRepository: WeatherRepository) : WeatherInteractor {
    override suspend fun getWeatherEntity(): WeatherEntity {
        return weatherRepository.getWeatherEntity()
    }
}