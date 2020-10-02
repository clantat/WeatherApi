package com.clantat.test.data.provider

import com.clantat.test.domain.entities.SettingsEntity
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface SettingsDatabaseProvider {
    suspend fun getSettings(): SettingsEntity
    suspend fun addSettings(settingsEntity: SettingsEntity)
    suspend fun updateSettings(settingsEntity: SettingsEntity)
}