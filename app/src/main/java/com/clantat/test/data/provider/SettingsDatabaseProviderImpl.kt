package com.clantat.test.data.provider

import com.clantat.test.data.database.SettingsDatabase
import com.clantat.test.data.database.SettingsDatabaseEntity
import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class SettingsDatabaseProviderImpl @Inject constructor(private val settingsDatabase: SettingsDatabase) :
    SettingsDatabaseProvider {

    override fun getSettings(): Single<SettingsEntity> {
        return settingsDatabase.SettingsDao().getSettings().map {
            SettingsEntity(it.id,it.themeMode)
        }
    }

    override fun addSettings(settingsEntity: SettingsEntity): Completable {
        return settingsDatabase.SettingsDao().insertSettings(SettingsDatabaseEntity(settingsEntity.id,settingsEntity.themeMode))
    }

    override fun updateSettings(settingsEntity: SettingsEntity): Completable {
        return settingsDatabase.SettingsDao().updateSettings(SettingsDatabaseEntity(settingsEntity.id,settingsEntity.themeMode))
    }
}