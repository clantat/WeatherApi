package com.clantat.test.domain.interactors

import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Single

interface RootInteractor {
    fun getSettings(): Single<SettingsEntity>
}