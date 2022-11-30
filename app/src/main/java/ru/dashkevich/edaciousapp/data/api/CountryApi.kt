package ru.dashkevich.edaciousapp.data.api

import retrofit2.http.GET
import ru.dashkevich.edaciousapp.data.CountryBaseURL
import ru.dashkevich.edaciousapp.data.model.Country

interface CountryApi {

    @GET("/countries")
    suspend fun getAllCounties() : List<Country>

}