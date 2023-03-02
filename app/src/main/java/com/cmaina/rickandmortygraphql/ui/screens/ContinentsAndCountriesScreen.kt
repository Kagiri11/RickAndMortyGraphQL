package com.cmaina.rickandmortygraphql.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cmaina.rickandmortygraphql.ui.MainViewModel

@Composable
fun ContinentsAndCountriesScreen(mainViewModel: MainViewModel) {
    val data = mainViewModel.continents.observeAsState().value
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        data?.onSuccess { continents ->
            continents?.let {
                items(it) { continent ->
                    Text(
                        text = continent.name,
                        modifier = Modifier.clickable {
                            mainViewModel.getCountriesOfSelectedContinent(continent.code)
                        }
                    )
                }
            }
        }?.onFailure {
            item {
                Text(text = it.message.toString())
            }
        }
    }
}
