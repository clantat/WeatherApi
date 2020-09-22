package com.example.test

import android.app.Application

class App : Application() {

    lateinit var appComponent: AppComponent
    var weatherFragmentComponent: WeatherFragmentComponent? = null

    companion object {
        lateinit var instance: App
            private set
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    fun plusWeatherFragmentComponent():WeatherFragmentComponent{
        return weatherFragmentComponent?:appComponent.plusWeatherFragmentComponent(WeatherModule())
    }
    fun clearWeatherFragmentComponent(){
        weatherFragmentComponent = null
    }

}