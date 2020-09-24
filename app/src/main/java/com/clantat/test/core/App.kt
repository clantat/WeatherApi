package com.clantat.test.core

import android.app.Application
import com.clantat.test.di.components.AppComponent
import com.clantat.test.di.components.DaggerAppComponent
import com.clantat.test.di.components.WeatherFragmentComponent
import com.clantat.test.di.modules.AppModule
import com.clantat.test.di.modules.WeatherModule

class App : Application() {

    lateinit var appComponent: AppComponent
    private var weatherFragmentComponent: WeatherFragmentComponent? = null

    companion object {
        lateinit var instance: App
            private set
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun plusWeatherFragmentComponent(): WeatherFragmentComponent {
        return weatherFragmentComponent
            ?: appComponent.plusWeatherFragmentComponent(WeatherModule())
    }

    fun clearWeatherFragmentComponent() {
        weatherFragmentComponent = null
    }

}