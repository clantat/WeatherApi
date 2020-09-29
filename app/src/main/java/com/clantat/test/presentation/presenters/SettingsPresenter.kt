package com.clantat.test.presentation.presenters

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.SettingsInteractor
import com.clantat.test.presentation.views.SettingsView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class SettingsPresenter @Inject constructor(private val settingsInteractor: SettingsInteractor) :
    MvpPresenter<SettingsView>() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun changeModeTheme(mode: Int) {
        compositeDisposable.add(
            settingsInteractor.addSettings(SettingsEntity(1, mode))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewState.showResult("Saved") },
                    { error -> viewState.showError("Cant save the theme: ${error.stackTrace}") })
        )
        viewState.changeTheme(mode)

    }

    fun addModeTheme(mode: Int) {
        compositeDisposable.add(
            settingsInteractor.updateSettings(SettingsEntity(1, mode))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewState.showResult("Saved") },
                    { error -> viewState.showError("Cant save the theme: ${error.stackTrace}") })
        )
        viewState.changeTheme(mode)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}