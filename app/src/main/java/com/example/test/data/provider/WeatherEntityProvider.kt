package com.example.test.data.provider

import com.example.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface WeatherEntityProvider {
    fun getWeatherEntity(): Single<WeatherEntity>
}