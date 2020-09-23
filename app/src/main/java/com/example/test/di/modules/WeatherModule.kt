package com.example.test.di.modules

import com.example.test.data.provider.WeatherEntityProvider
import com.example.test.data.provider.WeatherEntityProviderImpl
import com.example.test.data.repositories.WeatherGateway
import com.example.test.data.retrofit.WeatherReceiver
import com.example.test.di.scope.WeatherScope
import com.example.test.domain.interactors.WeatherInteractor
import com.example.test.domain.repositories.WeatherRepository
import com.example.test.domain.usecases.WeatherUseCase
import com.example.test.presentation.presenters.WeatherPresenter
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
