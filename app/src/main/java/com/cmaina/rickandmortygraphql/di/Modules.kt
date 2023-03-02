package com.cmaina.rickandmortygraphql.di

import com.cmaina.rickandmortygraphql.data.Clients
import com.cmaina.rickandmortygraphql.data.ClientsImpl
import com.cmaina.rickandmortygraphql.data.MainRepository
import com.cmaina.rickandmortygraphql.ui.MainViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val okHttpClient = OkHttpClient.Builder().build()

val Modules = module {
    single<Clients> { ClientsImpl(okHttpClient) }
    viewModelOf(::MainViewModel)
    single { MainRepository(get()) }
}
