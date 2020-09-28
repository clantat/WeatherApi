package com.clantat.test.presentation.presenters

import com.clantat.test.presentation.views.SettingsView
import moxy.MvpPresenter

class SettingsPresenter : MvpPresenter<SettingsView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun start() {
        //TODO добавить в Базу данных настройки и проверять их при запуске приложения
    }


}