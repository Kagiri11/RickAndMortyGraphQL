package com.cmaina.rickandmortygraphql.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmaina.rickandmortygraphql.countries.FindCountriesOfAContinentQuery
import com.cmaina.rickandmortygraphql.countries.GetContinentsQuery
import com.cmaina.rickandmortygraphql.data.MainRepository
import com.cmaina.rickandmortygraphql.rickandmorty.GetCharactersQuery
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _continents = MutableLiveData<Result<List<GetContinentsQuery.Continent>?>>()
    val continents: LiveData<Result<List<GetContinentsQuery.Continent>?>> get() = _continents

    private val _characters = MutableLiveData<Result<GetCharactersQuery.Characters?>>()
    val characters: LiveData<Result<GetCharactersQuery.Characters?>> get() = _characters

    private val _countriesOfAContinent =
        MutableLiveData<Result<List<FindCountriesOfAContinentQuery.Country>?>>()
    val countriesOfAContinent: LiveData<Result<List<FindCountriesOfAContinentQuery.Country>?>> get() = _countriesOfAContinent

    init {
        getCharacters()
    }

    fun getContinents() = viewModelScope.launch {
        try {
            val apiResponse = mainRepository.getContinents()
            if (!apiResponse.hasErrors()) {
                _continents.value = Result.success(apiResponse.data?.continents)
            } else {
                _continents.value = Result.failure(Throwable(apiResponse.errors.toString()))
            }
        } catch (e: Exception) {
            _continents.value = Result.failure(e)
        }
    }

    fun getCountriesOfSelectedContinent(continentCode: String) = viewModelScope.launch {
        try {
            val apiResponse =
                mainRepository.getCountriesOfSelectedContinent(continentCode = continentCode)
            if (!apiResponse.hasErrors()) {
                _countriesOfAContinent.value =
                    Result.success(apiResponse.data?.continent?.countries)
            } else {
                _countriesOfAContinent.value =
                    Result.failure(Throwable(apiResponse.errors.toString()))
            }
        } catch (e: Exception) {
            _countriesOfAContinent.value = Result.failure(e)
        }
    }

    fun getCharacters() = viewModelScope.launch {
        try {
            val apiResponse =
                mainRepository.getCharacters()

            Log.d("CharactersHere", "Result is : ${apiResponse}")
            if (!apiResponse.hasErrors()) {
                Log.d("CharactersHere", "Data is : ${apiResponse.data}")
                _characters.value = Result.success(apiResponse.data?.characters)
            } else {
                _characters.value =
                    Result.failure(Throwable(apiResponse.errors.toString()))
            }
        } catch (e: Exception) {
            _characters.value = Result.failure(e)
        }
    }
}
