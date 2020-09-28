package com.clantat.test.di.components

import com.clantat.test.core.App
import com.clantat.test.di.modules.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(app: App)
    fun plusMainActivityComponent(): MainActivityComponent
    fun plusWeatherFragmentComponent(weatherModule: WeatherModule): WeatherFragmentComponent
    fun plusRootFragmentComponent(rootModule: RootModule): RootFragmentComponent
    fun plusSettingFragmentComponent(settingsModule: SettingsModule): SettingsFragmentComponent
}