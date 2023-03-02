package com.cmaina.rickandmortygraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.cmaina.rickandmortygraphql.ui.MainViewModel
import com.cmaina.rickandmortygraphql.ui.screens.ContinentsAndCountriesScreen
import com.cmaina.rickandmortygraphql.ui.theme.RickAndMortyGraphQLTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getContinents()
        setContent {
            RickAndMortyGraphQLTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContinentsAndCountriesScreen(mainViewModel = mainViewModel)
                }
            }
        }
    }
}
