package com.clantat.test.di.modules

import android.content.Context
import com.clantat.test.core.App
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun provideContext(): Context{
        return app
    }

    @Singleton
    @Provides
    fun provideApp(): App {
        return app
    }

    @Singleton
    @Provides
    fun provideCicerone() : Cicerone<Router> {
        return Cicerone.create()
    }

}