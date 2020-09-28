package com.clantat.test.data.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
@Dao
interface SettingsDao {
    @Query("SELECT * FROM Settings")
    fun getSettings(): Single<SettingsDatabaseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSettings(settingsDatabaseEntity: SettingsDatabaseEntity): Completable

    @Update
    fun updateSettings(settingsDatabaseEntity: SettingsDatabaseEntity): Completable
}