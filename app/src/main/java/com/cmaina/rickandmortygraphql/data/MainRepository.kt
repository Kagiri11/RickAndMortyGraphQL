package com.cmaina.rickandmortygraphql.data

import com.cmaina.rickandmortygraphql.countries.FindCountriesOfAContinentQuery
import com.cmaina.rickandmortygraphql.countries.GetContinentsQuery
import com.cmaina.rickandmortygraphql.rickandmorty.GetCharactersQuery

class MainRepository(private val clients: Clients) {

    suspend fun getContinents() =
        clients.paymentsClient.query(GetContinentsQuery()).execute()

    val continentsQuery = GetContinentsQuery

    suspend fun getCountriesOfSelectedContinent(continentCode: String) =
        clients.retailExperienceClient.query(
            FindCountriesOfAContinentQuery(continentCode)
        ).execute()

    suspend fun getCharacters() =
        clients.retailExperienceClient.query(GetCharactersQuery()).execute()
}
