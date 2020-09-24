package com.clantat.test.di.modules

import com.clantat.test.data.provider.WeatherEntityProvider
import com.clantat.test.data.provider.WeatherEntityProviderImpl
import com.clantat.test.data.repositories.WeatherGateway
import com.clantat.test.data.retrofit.WeatherReceiver
import com.clantat.test.di.scope.WeatherScope
import com.clantat.test.domain.interactors.WeatherInteractor
import com.clantat.test.domain.repositories.WeatherRepository
import com.clantat.test.domain.usecases.WeatherUseCase
import com.clantat.test.presentation.presenters.WeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class WeatherModule {


    @WeatherScope
    @Provides
    fun provideWeatherPresenter(weatherInteractor: WeatherInteractor): WeatherPresenter {
        return WeatherPresenter(weatherInteractor)
    }

    @WeatherScope
    @Provides
    fun provideWeatherInteractor(weatherRepository: WeatherRepository): WeatherInteractor {
        return WeatherUseCase(weatherRepository)
    }

    @WeatherScope
    @Provides
    fun provideWeatherRepository(weatherEntityProvider: WeatherEntityProvider): WeatherRepository {
        return WeatherGateway(weatherEntityProvider)
    }

    @WeatherScope
    @Provides
    fun provideWeatherEntityProvider(weatherReceiver: WeatherReceiver): WeatherEntityProvider {
        return WeatherEntityProviderImpl(weatherReceiver)
    }
}
