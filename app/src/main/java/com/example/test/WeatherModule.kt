package com.example.test

import dagger.Module
import dagger.Provides

@Module
class WeatherModule {

    @WeatherScope
    @Provides
    fun provideWeatherPresenter(): WeatherPresenter{
        return WeatherPresenter()
    }
}