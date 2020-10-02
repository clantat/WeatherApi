package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.SettingsInteractor
import com.clantat.test.domain.repositories.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SettingsUseCase(private val settingsRepository: SettingsRepository) : SettingsInteractor {

    override suspend fun addSettings(settingsEntity: SettingsEntity) = withContext(Dispatchers.IO) {
        settingsRepository.addSettings(settingsEntity)
    }

    override suspend fun updateSettings(settingsEntity: SettingsEntity) =
        withContext(Dispatchers.IO) {
            settingsRepository.updateSettings(settingsEntity)
        }

}