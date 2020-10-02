package com.clantat.test.presentation.presenters

import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.SettingsInteractor
import com.clantat.test.presentation.views.SettingsView
import kotlinx.coroutines.*
import moxy.MvpPresenter
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SettingsPresenter @Inject constructor(private val settingsInteractor: SettingsInteractor) :
    MvpPresenter<SettingsView>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun changeModeTheme(mode: Int) {
        launch {
            withContext(Dispatchers.IO) {
                settingsInteractor.addSettings(SettingsEntity(23, 324))
            }
            // TODO ввести проверку в котлине на сохранение данных в бд complitable в RXjava
            viewState.showResult("Saved")
        }
    }

    fun addModeTheme(mode: Int) {
        launch {
            withContext(Dispatchers.IO) {
                settingsInteractor.updateSettings(SettingsEntity(990, mode))
            }
            viewState.showResult("Saved")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}