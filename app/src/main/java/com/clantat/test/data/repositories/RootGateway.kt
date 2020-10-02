package com.clantat.test.data.repositories

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.repositories.RootRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RootGateway(private val settingsDatabaseProvider: SettingsDatabaseProvider) : RootRepository {
    override suspend fun getSettings(): SettingsEntity {
        return settingsDatabaseProvider.getSettings()
    }
}