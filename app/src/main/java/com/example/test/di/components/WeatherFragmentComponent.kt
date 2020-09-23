package com.example.test.di.components

import com.example.test.di.modules.ApiModule
import com.example.test.di.modules.WeatherModule
import com.example.test.di.scope.WeatherScope
import com.example.test.presentation.fragments.WeatherFragment
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class, ApiModule::class])
interface WeatherFragmentComponent {
    fun inject(weatherFragment: WeatherFragment)
}