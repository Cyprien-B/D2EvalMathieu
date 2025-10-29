package com.example.evalmathieud2.home.data.remote

import com.example.evalmathieud2.home.data.remote.dto.CharactersResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Client HTTP Ktor configuré pour Android
 * Gère les appels à l'API Dragon Ball
 */
class DragonBallApiClient {

    // Configuration du client HTTP Ktor
    private val httpClient = HttpClient(Android) {
        // Configuration de la sérialisation JSON
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        // Configuration du logging pour le débogage
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("Ktor: $message")
                }
            }
            level = LogLevel.ALL
        }
    }

    companion object {
        private const val BASE_URL = "https://dragonball-api.com/api"
    }

    /**
     * Récupère la liste des personnages de Dragon Ball
     * @param page Numéro de la page (par défaut 1)
     * @param limit Nombre d'éléments par page (par défaut 10)
     * @return CharactersResponseDto contenant la liste des personnages et les métadonnées
     */
    suspend fun getCharacters(
        page: Int = 1,
        limit: Int = 10
    ): CharactersResponseDto {
        return httpClient.get("$BASE_URL/characters") {
            url {
                parameters.append("page", page.toString())
                parameters.append("limit", limit.toString())
            }
        }.body()
    }

}
