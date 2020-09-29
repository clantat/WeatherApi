package com.clantat.test.domain.repositories

import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Single

interface RootRepository {
    fun getSettings(): Single<SettingsEntity>
}