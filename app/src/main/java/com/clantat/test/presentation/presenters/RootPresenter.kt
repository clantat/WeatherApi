package com.clantat.test.presentation.presenters

import android.util.Log
import com.clantat.test.core.App
import com.clantat.test.core.SettingsScreen
import com.clantat.test.core.WeatherScreen
import com.clantat.test.presentation.views.RootView
import moxy.MvpPresenter

class RootPresenter : MvpPresenter<RootView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun goToWeather() {
        App.instance.cicerone.router.navigateTo(WeatherScreen("18"))
    }

    fun goToSettings(){
        App.instance.cicerone.router.navigateTo(SettingsScreen())
    }
}