package com.clantat.test.di.components

import com.clantat.test.di.modules.ApiModule
import com.clantat.test.di.modules.WeatherModule
import com.clantat.test.di.scope.WeatherScope
import com.clantat.test.presentation.fragments.WeatherFragment
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class, ApiModule::class])
interface WeatherFragmentComponent {
    fun inject(weatherFragment: WeatherFragment)
}