package com.tc.kmp.tutorial.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object TodoNetwork {

    val networkClient = createClient()
}

fun createClient(): HttpClient {

    return HttpClient {
        install(ContentNegotiation){
            json(
                Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}
