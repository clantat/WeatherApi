package com.clantat.test.di.modules

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.data.repositories.SettingsGateway
import com.clantat.test.di.scope.SettingsScope
import com.clantat.test.domain.interactors.SettingsInteractor
import com.clantat.test.domain.repositories.SettingsRepository
import com.clantat.test.domain.usecases.SettingsUseCase
import com.clantat.test.presentation.presenters.SettingsPresenter
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {
    @SettingsScope
    @Provides
    fun provideSettingsPresenter(settingsInteractor: SettingsInteractor): SettingsPresenter{
        return SettingsPresenter(settingsInteractor)
    }
    @SettingsScope
    @Provides
    fun provideSettingsInteractor(settingsRepository: SettingsRepository):SettingsInteractor{
        return SettingsUseCase(settingsRepository)
    }
    @SettingsScope
    @Provides
    fun provideSettingsRepository(settingsDatabaseProvider: SettingsDatabaseProvider):SettingsRepository{
        return SettingsGateway(settingsDatabaseProvider)
    }


}