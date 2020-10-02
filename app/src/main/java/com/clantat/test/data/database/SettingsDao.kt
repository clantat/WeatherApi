package com.clantat.test.data.database

import androidx.room.*

@Dao
interface SettingsDao {
    @Query("SELECT * FROM Settings")
    suspend fun getSettings(): SettingsDatabaseEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(settingsDatabaseEntity: SettingsDatabaseEntity)

    @Update
    suspend fun updateSettings(settingsDatabaseEntity: SettingsDatabaseEntity)
}