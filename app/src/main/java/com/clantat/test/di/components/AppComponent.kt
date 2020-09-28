package com.clantat.test.di.components

import com.clantat.test.core.App
import com.clantat.test.di.modules.AppModule
import com.clantat.test.di.modules.RootModule
import com.clantat.test.di.modules.SettingsModule
import com.clantat.test.di.modules.WeatherModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun plusMainActivityComponent(): MainActivityComponent
    fun plusWeatherFragmentComponent(weatherModule: WeatherModule): WeatherFragmentComponent
    fun plusRootFragmentComponent(rootModule: RootModule): RootFragmentComponent
    fun plusSettingFragmentComponent(settingsModule: SettingsModule): SettingsFragmentComponent
}