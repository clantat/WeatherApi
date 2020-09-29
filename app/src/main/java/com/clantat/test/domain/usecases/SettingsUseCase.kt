package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.SettingsInteractor
import com.clantat.test.domain.repositories.SettingsRepository
import io.reactivex.rxjava3.core.Completable

class SettingsUseCase(private val settingsRepository: SettingsRepository):SettingsInteractor {

    override fun addSettings(settingsEntity: SettingsEntity): Completable {
        return settingsRepository.addSettings(settingsEntity)
    }

    override fun updateSettings(settingsEntity: SettingsEntity): Completable {
        return settingsRepository.updateSettings(settingsEntity)
    }

}