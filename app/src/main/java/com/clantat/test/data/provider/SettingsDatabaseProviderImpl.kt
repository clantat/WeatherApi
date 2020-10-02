package com.clantat.test.data.provider

import com.clantat.test.data.database.SettingsDatabase
import com.clantat.test.data.database.SettingsDatabaseEntity
import com.clantat.test.domain.entities.SettingsEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SettingsDatabaseProviderImpl @Inject constructor(private val settingsDatabase: SettingsDatabase) :
    SettingsDatabaseProvider {

    override suspend fun getSettings(): SettingsEntity = withContext(Dispatchers.IO) {
        SettingsEntity(settingsDatabase.SettingsDao().getSettings().id,settingsDatabase.SettingsDao().getSettings().themeMode)
    }

    override suspend fun addSettings(settingsEntity: SettingsEntity)= withContext(Dispatchers.IO) {
        settingsDatabase.SettingsDao().insertSettings(SettingsDatabaseEntity(settingsEntity.id,settingsEntity.themeMode))
    }

    override suspend fun updateSettings(settingsEntity: SettingsEntity) = withContext(Dispatchers.IO){
        settingsDatabase.SettingsDao().updateSettings(SettingsDatabaseEntity(settingsEntity.id,settingsEntity.themeMode))
    }
}