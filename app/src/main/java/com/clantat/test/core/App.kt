package com.clantat.test.core

import android.app.Application
import com.clantat.test.di.components.*
import com.clantat.test.di.modules.AppModule
import com.clantat.test.di.modules.RootModule
import com.clantat.test.di.modules.SettingsModule
import com.clantat.test.di.modules.WeatherModule
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var cicerone: Cicerone<Router>
    lateinit var appComponent: AppComponent
    private var mainActivityComponent: MainActivityComponent? = null
    private var rootFragmentComponent: RootFragmentComponent? = null
    private var settingsFragmentComponent: SettingsFragmentComponent? = null
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
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
            .apply { inject(this@App) }
    }

    fun plusMainActivityComponent(): MainActivityComponent {
        return mainActivityComponent
            ?: appComponent.plusMainActivityComponent()
    }

    fun clearMainActivityComponent() {
        mainActivityComponent = null
    }

    fun plusRootFragmentComponent(): RootFragmentComponent {
        return rootFragmentComponent
            ?: appComponent.plusRootFragmentComponent(RootModule())
    }

    fun clearRootFragmentComponent() {
        rootFragmentComponent = null
    }

    fun plusSettingsFragmentComponent(): SettingsFragmentComponent {
        return settingsFragmentComponent
            ?: appComponent.plusSettingFragmentComponent(SettingsModule())
    }

    fun clearSettingsFragmentComponent() {
        settingsFragmentComponent = null
    }


    fun plusWeatherFragmentComponent(): WeatherFragmentComponent {
        return weatherFragmentComponent
            ?: appComponent.plusWeatherFragmentComponent(WeatherModule())
    }

    fun clearWeatherFragmentComponent() {
        weatherFragmentComponent = null
    }


}