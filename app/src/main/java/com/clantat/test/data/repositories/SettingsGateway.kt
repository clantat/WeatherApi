package com.clantat.test.data.repositories

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.repositories.SettingsRepository

class SettingsGateway(private val settingsDatabaseProvider: SettingsDatabaseProvider) :
    SettingsRepository {
    override suspend fun addSettings(settingsEntity: SettingsEntity) {
        settingsDatabaseProvider.addSettings(settingsEntity)
    }

    override suspend fun updateSettings(settingsEntity: SettingsEntity) {
        settingsDatabaseProvider.updateSettings(settingsEntity)
    }

    override suspend fun getSettings(): SettingsEntity {
        return settingsDatabaseProvider.getSettings()
    }
}