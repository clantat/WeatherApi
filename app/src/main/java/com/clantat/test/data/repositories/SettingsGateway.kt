package com.clantat.test.data.repositories

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.repositories.SettingsRepository
import io.reactivex.rxjava3.core.Completable

class SettingsGateway(private val settingsDatabaseProvider: SettingsDatabaseProvider) : SettingsRepository{
    override fun addSettings(settingsEntity: SettingsEntity): Completable {
        return settingsDatabaseProvider.addSettings(settingsEntity)
    }
    override fun updateSettings(settingsEntity: SettingsEntity): Completable {
        return settingsDatabaseProvider.updateSettings(settingsEntity)
    }
}