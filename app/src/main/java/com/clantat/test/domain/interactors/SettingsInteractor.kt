package com.clantat.test.domain.interactors

import com.clantat.test.domain.entities.SettingsEntity

interface SettingsInteractor {
    suspend fun addSettings(settingsEntity: SettingsEntity)
    suspend fun updateSettings(settingsEntity: SettingsEntity)
    suspend fun getSettings(): SettingsEntity
}