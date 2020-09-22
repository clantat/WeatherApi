package com.example.test

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun plusWeatherFragmentComponent(weatherModule: WeatherModule): WeatherFragmentComponent
}