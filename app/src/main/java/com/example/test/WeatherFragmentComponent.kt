package com.example.test

import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class])
interface WeatherFragmentComponent {
    fun inject(weatherFragment: WeatherFragment)
}