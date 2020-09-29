package com.clantat.test.presentation.presenters

import com.clantat.test.core.App
import com.clantat.test.core.SettingsScreen
import com.clantat.test.core.WeatherScreen
import com.clantat.test.domain.interactors.RootInteractor
import com.clantat.test.presentation.views.RootView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class RootPresenter @Inject constructor(private val rootInteractor: RootInteractor) : MvpPresenter<RootView>() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

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
        compositeDisposable.add(rootInteractor.getSettings()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { entity -> viewState.setThemeMode(entity.themeMode) }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}