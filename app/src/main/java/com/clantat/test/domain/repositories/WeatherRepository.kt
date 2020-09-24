package com.clantat.test.domain.repositories

import com.clantat.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {
    fun getWeatherEntity(): Single<WeatherEntity>
}