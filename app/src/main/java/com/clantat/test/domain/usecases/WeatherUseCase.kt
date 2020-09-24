package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.WeatherEntity
import com.clantat.test.domain.interactors.WeatherInteractor
import com.clantat.test.domain.repositories.WeatherRepository
import io.reactivex.rxjava3.core.Single

class WeatherUseCase(private val weatherRepository: WeatherRepository): WeatherInteractor {
    override fun getWeatherEntity(): Single<WeatherEntity> {
        return weatherRepository.getWeatherEntity()
    }
}