package com.clantat.test.domain.repositories

import com.clantat.test.domain.entities.SettingsEntity

interface SettingsRepository {
    suspend fun addSettings(settingsEntity: SettingsEntity)
    suspend fun updateSettings(settingsEntity: SettingsEntity)
    suspend fun getSettings():SettingsEntity
}