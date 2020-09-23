package com.example.test.domain.usecases

import com.example.test.domain.entities.WeatherEntity
import com.example.test.domain.interactors.WeatherInteractor
import com.example.test.domain.repositories.WeatherRepository
import io.reactivex.rxjava3.core.Single

class WeatherUseCase(private val weatherRepository: WeatherRepository): WeatherInteractor {
    override fun getWeatherEntity(): Single<WeatherEntity> {
        return weatherRepository.getWeatherEntity()
    }
}