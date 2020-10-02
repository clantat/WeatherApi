package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.RootInteractor
import com.clantat.test.domain.repositories.RootRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RootUseCase(private val rootRepository: RootRepository) : RootInteractor {
    override  suspend fun getSettings(): SettingsEntity = withContext(Dispatchers.IO) {
        rootRepository.getSettings()
    }
}