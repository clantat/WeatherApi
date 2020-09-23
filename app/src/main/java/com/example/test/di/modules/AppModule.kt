package com.example.test.di.modules

import android.content.Context
import com.example.test.core.App
import dagger.Module
import dagger.Provides
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

}