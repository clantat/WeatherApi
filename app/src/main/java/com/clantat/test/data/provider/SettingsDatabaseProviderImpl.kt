package com.clantat.test.data.provider

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.clantat.test.data.database.SettingsDatabase
import com.clantat.test.data.database.SettingsDatabaseEntity
import com.clantat.test.domain.entities.SettingsEntity
import javax.inject.Inject


class SettingsDatabaseProviderImpl @Inject constructor(private val settingsDatabase: SettingsDatabase) :
    SettingsDatabaseProvider {

    override suspend fun getSettings(): SettingsEntity {
        return SettingsEntity(
            settingsDatabase.SettingsDao().getSettings()?.id?:1,
            settingsDatabase.SettingsDao().getSettings()?.themeMode?:MODE_NIGHT_NO
        )
    }

    override suspend fun addSettings(settingsEntity: SettingsEntity) {
        settingsDatabase.SettingsDao()
            .insertSettings(SettingsDatabaseEntity(settingsEntity.id, settingsEntity.themeMode))
        Log.i("CHIK", "addSettings: insert settings " + settingsEntity.themeMode)
    }

    override suspend fun updateSettings(settingsEntity: SettingsEntity) {
        settingsDatabase.SettingsDao()
            .updateSettings(SettingsDatabaseEntity(settingsEntity.id, settingsEntity.themeMode))
        Log.i("CHIK", "addSettings: update settings " + settingsEntity.themeMode)
    }
}