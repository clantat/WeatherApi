package com.example.test.di.components

import com.example.test.core.MainActivity
import com.example.test.di.modules.AppModule
import com.example.test.di.modules.WeatherModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun plusWeatherFragmentComponent(weatherModule: WeatherModule): WeatherFragmentComponent
}