package ru.dashkevich.edaciousapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.dashkevich.edaciousapp.data.CountryBaseURL
import ru.dashkevich.edaciousapp.data.api.CountryApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverter: GsonConverterFactory): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(gsonConverter)
            .baseUrl(CountryBaseURL)
            .build()

    @Provides
    @Singleton
    fun provideCountryApi(retrofit: Retrofit): CountryApi =
        retrofit.create(CountryApi::class.java)


}