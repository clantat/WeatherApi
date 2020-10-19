package com.clantat.test.presentation.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RootView : MvpView {
    fun setThemeMode(themeMode: Int)
    fun error(message:String)
}