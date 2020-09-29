package com.clantat.test.presentation.presenters

import com.clantat.test.domain.interactors.WeatherInteractor
import com.clantat.test.presentation.views.WeatherView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject


@InjectViewState
class WeatherPresenter @Inject constructor(private val weatherInteractor: WeatherInteractor) :
    MvpPresenter<WeatherView>() {
    private var temp: String? = null
    private var humidity: String? = null
    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun start() {
        disposable = weatherInteractor.getWeatherEntity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weatherEntity ->
                viewState.showDegrees("Температура в Ижевске ${weatherEntity.degrees}C")
                viewState.showHumidity("Влажность ${weatherEntity.humidity}Ф")
            }, { e -> error(e) })
//
//        GlobalScope.launch(Dispatchers.IO) {
//            val apiServiceCor = GismeteoApi.createCoroutines()
//            humidity = apiServiceCor.searchCoroutine().await().list.get(0).main.humidity
//            if (humidity != null) viewState.showHumidity("Влажность в Ижевске ${humidity}Ф")
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}