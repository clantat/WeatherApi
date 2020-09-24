package com.clantat.test.di.components

import com.clantat.test.core.MainActivity
import com.clantat.test.di.modules.AppModule
import com.clantat.test.di.modules.WeatherModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun plusWeatherFragmentComponent(weatherModule: WeatherModule): WeatherFragmentComponent
}