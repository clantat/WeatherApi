package com.clantat.test.di.modules

import android.content.Context
import androidx.room.Room
import com.clantat.test.core.Constants.DB_NAME
import com.clantat.test.data.database.SettingsDatabase
import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.data.provider.SettingsDatabaseProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideSettingsDatabase(context: Context): SettingsDatabase{
        return Room.databaseBuilder(context,SettingsDatabase::class.java,DB_NAME).build()
    }
    @Singleton
    @Provides
    fun provideSettingsDatabaseProvider(settingsDatabase: SettingsDatabase):SettingsDatabaseProvider{
        return SettingsDatabaseProviderImpl(settingsDatabase)
    }
}