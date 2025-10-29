package com.example.evalmathieud2.home.data

import com.example.evalmathieud2.home.data.local.CharacterDao
import com.example.evalmathieud2.home.data.local.toDomain
import com.example.evalmathieud2.home.data.local.toEntity
import com.example.evalmathieud2.home.data.remote.DragonBallApiClient
import com.example.evalmathieud2.home.data.remote.mapper.CharacterMapper
import com.example.evalmathieud2.home.domain.Character
import com.example.evalmathieud2.home.domain.CharactersRepository

/**
 * Implémentation du repository avec cache Room.
 * Sauvegarde automatiquement les données API dans la BDD locale.
 */
class CharactersRepositoryImpl(
    private val apiClient: DragonBallApiClient,
    private val characterDao: CharacterDao
) : CharactersRepository {

    /**
     * Récupère les personnages depuis l'API et les met en cache.
     * En cas d'erreur réseau, retourne les données en cache si disponibles.
     */
    override suspend fun getCharacters(): List<Character> {
        return try {
            val response = apiClient.getCharacters()
            val characters = CharacterMapper.toCharacterList(response.items)

            // Sauvegarde en cache local
            characterDao.insertCharacters(characters.map { it.toEntity() })

            characters
        } catch (e: Exception) {
            // Fallback sur le cache en cas d'erreur réseau
            val cachedCharacters = characterDao.getAllCharacters()
            if (cachedCharacters.isNotEmpty()) {
                cachedCharacters.map { it.toDomain() }
            } else {
                throw e
            }
        }
    }
}