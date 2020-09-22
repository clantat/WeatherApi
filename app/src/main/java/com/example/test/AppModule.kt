package com.example.test

import android.content.Context
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
    fun provideApp(): App{
        return app
    }

}