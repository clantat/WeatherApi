package com.example.test

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class WeatherPresenter : MvpPresenter<WeatherView>() {
    private var temp: String? = null
    private var humidity: String? = null
    fun start() {
        val apiServiceRX = GismeteoApiService.createRX()
        apiServiceRX.searchRX()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                temp = it.list.get(0).main.temp
            }, { error("GG") }, {
                if (temp != null)
                    viewState.showDegrees("Температура в Ижевске ${temp}C")
            })

        GlobalScope.launch(Dispatchers.IO) {
            val apiServiceCor = GismeteoApiService.createCoroutines()
            humidity = apiServiceCor.searchCoroutine().await().list.get(0).main.humidity
            if (humidity != null) viewState.showHumidity("Влажность в Ижевске ${humidity}Ф")
        }
    }
}