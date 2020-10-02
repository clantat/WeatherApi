package com.clantat.test.domain.interactors

import com.clantat.test.domain.entities.SettingsEntity

interface RootInteractor {
    suspend fun getSettings(): SettingsEntity
}