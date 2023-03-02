package com.cmaina.rickandmortygraphql

import android.app.Application
import com.cmaina.rickandmortygraphql.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApp)
            val rickAndMortyModules = listOf(Modules)
            modules(rickAndMortyModules)
        }
    }
}
