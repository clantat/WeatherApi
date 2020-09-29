package com.clantat.test.di.modules

import com.clantat.test.data.provider.SettingsDatabaseProvider
import com.clantat.test.data.repositories.RootGateway
import com.clantat.test.di.scope.RootScope
import com.clantat.test.domain.interactors.RootInteractor
import com.clantat.test.domain.repositories.RootRepository
import com.clantat.test.domain.usecases.RootUseCase
import com.clantat.test.presentation.presenters.RootPresenter
import dagger.Module
import dagger.Provides

@Module
class RootModule {

    @RootScope
    @Provides
    fun provideRootPresenter(rootInteractor: RootInteractor): RootPresenter{
        return RootPresenter(rootInteractor)
    }

    @RootScope
    @Provides
    fun provideRootInteractor(rootRepository: RootRepository):RootInteractor{
        return RootUseCase(rootRepository)
    }

    @RootScope
    @Provides
    fun provideRootRepository(settingsDatabaseProvider: SettingsDatabaseProvider): RootRepository{
        return RootGateway(settingsDatabaseProvider)
    }

}