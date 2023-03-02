package com.cmaina.rickandmortygraphql.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

interface Clients {
    val retailExperienceClient: ApolloClient

    val paymentsClient: ApolloClient
}

class ClientsImpl(okHttpClient: OkHttpClient) : Clients {
    override val retailExperienceClient: ApolloClient = ApolloClient.Builder()
        .serverUrl("https://rickandmortyapi.com/graphql")
        .okHttpClient(okHttpClient)
        .build()

    override val paymentsClient: ApolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com")
        .okHttpClient(okHttpClient)
        .build()
}
