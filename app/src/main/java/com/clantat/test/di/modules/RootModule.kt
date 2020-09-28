package com.clantat.test.di.modules

import com.clantat.test.di.scope.RootScope
import com.clantat.test.presentation.presenters.RootPresenter
import dagger.Module
import dagger.Provides

@Module
class RootModule {

    @RootScope
    @Provides
    fun provideRootPresenter(): RootPresenter{
        return RootPresenter()
    }
}