package com.example.test.presentation.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface WeatherView : MvpView {
    fun showHumidity(humidity: String)
    fun showDegrees(degrees: String)

}