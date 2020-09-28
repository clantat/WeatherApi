package com.clantat.test.data.provider

import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SettingsDatabaseProvider {
    fun getSettings(): Single<SettingsEntity>
    fun addSettings(settingsEntity: SettingsEntity): Completable
    fun updateSettings(settingsEntity: SettingsEntity): Completable
}