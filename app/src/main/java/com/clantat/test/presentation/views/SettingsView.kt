package com.clantat.test.presentation.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SettingsView : MvpView {
    fun changeTheme(modeTheme: Int)
    fun showError(message: String)
    fun showResult(message: String)
}