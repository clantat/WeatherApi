package com.clantat.test.di.modules

import com.clantat.test.di.scope.SettingsScope
import com.clantat.test.presentation.presenters.SettingsPresenter
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {
    @SettingsScope
    @Provides
    fun provideSettingsPresenter(): SettingsPresenter{
        return SettingsPresenter()
    }
}