package com.clantat.test.data.repositories

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.domain.entities.SettingsEntity
import com.clantat.test.domain.repositories.RootRepository
import io.reactivex.rxjava3.core.Single

class RootGateway(private val settingsDatabaseProvider: SettingsDatabaseProvider):RootRepository {
    override fun getSettings(): Single<SettingsEntity> {
        return settingsDatabaseProvider.getSettings()
    }
}