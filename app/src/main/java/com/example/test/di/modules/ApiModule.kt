package com.example.test.di.modules

import android.content.Context
import com.example.test.R
import com.example.test.core.Constants.WEATHER_GISMETEO_URL
import com.example.test.data.retrofit.GismeteoApi
import com.example.test.data.retrofit.WeatherGismeteoApi
import com.example.test.data.retrofit.WeatherReceiver
import com.example.test.di.scope.WeatherScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class ApiModule {

    @WeatherScope
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @WeatherScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @WeatherScope
    @Provides
    @Named("GismeteoApiRX")
    fun provideGismeteoApiRX(gson: Gson, okHttpClient: OkHttpClient): GismeteoApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(WEATHER_GISMETEO_URL)
            .client(okHttpClient)
            .build()
            .create(GismeteoApi::class.java)
    }

    @WeatherScope
    @Provides
    @Named("GismeteoApiCoroutines")
    fun provideGismeteoApiCoroutines(gson: Gson, okHttpClient: OkHttpClient): GismeteoApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(WEATHER_GISMETEO_URL)
            .client(okHttpClient)
            .build()
            .create(GismeteoApi::class.java)
    }

    @WeatherScope
    @Provides
    fun provideWeatherReceiver(
        @Named("GismeteoApiRX") gismeteoApi: GismeteoApi,
        context: Context
    ): WeatherReceiver {
        return WeatherGismeteoApi(gismeteoApi, context.getString(R.string.GismeteoApiKey))
    }

}