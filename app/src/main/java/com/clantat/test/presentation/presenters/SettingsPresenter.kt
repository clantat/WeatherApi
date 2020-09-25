package com.clantat.test.presentation.presenters

import com.clantat.test.presentation.views.SettingsView
import moxy.MvpPresenter

class SettingsPresenter : MvpPresenter<SettingsView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //viewState.requestContactsPermission()
    }

    fun start() {
    }


}