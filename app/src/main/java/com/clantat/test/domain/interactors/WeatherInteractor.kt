package com.clantat.test.domain.interactors

import com.clantat.test.domain.entities.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface WeatherInteractor {
    fun getWeatherEntity(): Single<WeatherEntity>
}