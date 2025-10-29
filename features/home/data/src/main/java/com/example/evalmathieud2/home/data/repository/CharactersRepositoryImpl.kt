package com.example.evalmathieud2.home.data.repository

import com.example.evalmathieud2.home.data.remote.DragonBallApiClient
import com.example.evalmathieud2.home.data.remote.mapper.CharacterMapper
import com.example.evalmathieud2.home.domain.Character
import com.example.evalmathieud2.home.domain.CharactersRepository

/**
 * Implémentation du repository des personnages
 * Récupère les données de l'API et les convertit en objets du domaine
 */
class CharactersRepositoryImpl(
    private val apiClient: DragonBallApiClient
) : CharactersRepository {


    override suspend fun getCharacters(): List<Character> {
        // Appel à l'API pour récupérer les données
        val response = apiClient.getCharacters()

        // Conversion des DTOs en objets du domaine via le mapper
        return CharacterMapper.toCharacterList(response.items)
    }
}

