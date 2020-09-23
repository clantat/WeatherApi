package com.example.test.domain.interactors

import com.example.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface WeatherInteractor {
    fun getWeatherEntity(): Single<WeatherEntity>
}