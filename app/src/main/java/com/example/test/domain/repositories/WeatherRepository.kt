package com.example.test.domain.repositories

import com.example.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {
    fun getWeatherEntity(): Single<WeatherEntity>
}