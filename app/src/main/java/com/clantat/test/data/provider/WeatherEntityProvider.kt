package com.clantat.test.data.provider

import com.clantat.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface WeatherEntityProvider {
    fun getWeatherEntity(): Single<WeatherEntity>
}