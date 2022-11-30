package ru.dashkevich.edaciousapp.data.repository

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import ru.dashkevich.edaciousapp.data.api.CountryApi
import ru.dashkevich.edaciousapp.data.model.Country
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CountryRepository @Inject constructor(
    private val countryApi: CountryApi,
    private val dispatcher: CoroutineDispatcher
) {


    suspend fun getAllCountries(): Result<List<Country>> {
        return runCatching {
            withContext(dispatcher) {
                countryApi.getAllCounties()
            }
        }
    }


}