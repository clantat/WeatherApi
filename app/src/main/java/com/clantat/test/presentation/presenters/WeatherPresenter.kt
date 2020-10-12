package com.clantat.test.presentation.presenters

import android.util.Log
import androidx.annotation.MainThread
import com.clantat.test.domain.interactors.WeatherInteractor
import com.clantat.test.presentation.views.WeatherView
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@InjectViewState
class WeatherPresenter @Inject constructor(private val weatherInteractor: WeatherInteractor) :
    MvpPresenter<WeatherView>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun start() {
//        disposable = weatherInteractor.getWeatherEntity()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ weatherEntity ->
//                viewState.showDegrees("Температура в Ижевске ${weatherEntity.degrees}C")
//                viewState.showHumidity("Влажность ${weatherEntity.humidity}Ф")
//            }, { e -> error(e) })

        launch {
            var degrees: String = "Определяем температуру"
            var humidity: String = "Опеределяем влажность"
            withContext(Dispatchers.IO) {
                    degrees = weatherInteractor.getWeatherEntity().degrees
                    humidity = weatherInteractor.getWeatherEntity().humidity
            }
            viewState.showDegrees("Температура в Ижевске ${degrees }C")
            viewState.showHumidity("Влажность ${humidity}Ф")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}