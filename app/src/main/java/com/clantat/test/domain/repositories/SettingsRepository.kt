package com.clantat.test.domain.repositories

import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Completable

interface SettingsRepository {
    fun addSettings(settingsEntity: SettingsEntity): Completable
    fun updateSettings(settingsEntity: SettingsEntity): Completable
}