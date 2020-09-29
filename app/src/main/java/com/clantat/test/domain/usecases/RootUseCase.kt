package com.clantat.test.domain.usecases

import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.interactors.RootInteractor
import com.clantat.test.domain.repositories.RootRepository
import io.reactivex.rxjava3.core.Single

class RootUseCase(private val rootRepository: RootRepository): RootInteractor {
    override fun getSettings(): Single<SettingsEntity> {
        return rootRepository.getSettings()
    }
}