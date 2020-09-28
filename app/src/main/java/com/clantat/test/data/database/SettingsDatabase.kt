package com.clantat.test.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clantat.test.core.Constants.DB_VERSION

@Database(entities = [SettingsDatabaseEntity::class], version = DB_VERSION)
abstract class SettingsDatabase : RoomDatabase() {
    abstract fun SettingsDao(): SettingsDao
}