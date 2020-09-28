package com.clantat.test.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Settings")
class SettingsDatabaseEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val themeMode: String
)