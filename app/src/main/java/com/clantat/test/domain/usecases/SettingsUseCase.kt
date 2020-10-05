package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.SettingsInteractor
import com.clantat.test.domain.repositories.SettingsRepository

class SettingsUseCase(private val settingsRepository: SettingsRepository) : SettingsInteractor {

    override suspend fun addSettings(settingsEntity: SettingsEntity) {
        settingsRepository.addSettings(settingsEntity)
    }

    override suspend fun updateSettings(settingsEntity: SettingsEntity) {
        settingsRepository.updateSettings(settingsEntity)
    }

    override suspend fun getSettings(): SettingsEntity {
        return settingsRepository.getSettings()
    }

}