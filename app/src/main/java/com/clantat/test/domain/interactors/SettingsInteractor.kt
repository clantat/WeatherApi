package com.clantat.test.domain.interactors

import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Completable

interface SettingsInteractor {
    fun addSettings(settingsEntity: SettingsEntity):Completable
    fun updateSettings(settingsEntity: SettingsEntity):Completable
}