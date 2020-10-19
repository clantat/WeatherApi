package com.clantat.test.presentation.presenters

import android.util.Log
import com.clantat.test.core.App
import com.clantat.test.core.SettingsScreen
import com.clantat.test.core.WeatherScreen
import com.clantat.test.domain.interactors.RootInteractor
import com.clantat.test.presentation.views.RootView
import kotlinx.coroutines.*
import moxy.MvpPresenter
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RootPresenter @Inject constructor(private val rootInteractor: RootInteractor) :
    MvpPresenter<RootView>(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()

    }

    fun goToWeather() {
        App.instance.cicerone.router.navigateTo(WeatherScreen("18"))
    }

    fun goToSettings() {
        App.instance.cicerone.router.navigateTo(SettingsScreen())
    }

    fun getSettings() {
        launch {
            withContext(Dispatchers.IO) {
                Log.i("fsdf", "getSettings: " +                 rootInteractor.getSettings().toString())
                Log.i("fsdf", "getSettings: " +                 rootInteractor.getSettings())

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}