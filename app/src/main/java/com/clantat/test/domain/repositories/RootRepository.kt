package com.clantat.test.domain.repositories

import com.clantat.test.domain.entities.SettingsEntity

interface RootRepository {
    suspend fun getSettings(): SettingsEntity
}