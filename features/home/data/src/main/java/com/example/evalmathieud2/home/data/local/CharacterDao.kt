package com.example.evalmathieud2.home.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * DAO (Data Access Object) pour les opérations sur la table des personnages.
 *
 * Fournit les méthodes CRUD pour gérer le cache local des personnages Dragon Ball.
 *
 * @see CharacterEntity
 */
@Dao
interface CharacterDao {

    /**
     * Récupère tous les personnages depuis la base de données locale.
     *
     * @return Liste de tous les personnages en cache
     */
    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<CharacterEntity>

    /**
     * Récupère un personnage par son identifiant.
     *
     * @param id Identifiant du personnage
     * @return Le personnage correspondant ou null si non trouvé
     */
    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Int): CharacterEntity?

    /**
     * Insert ou met à jour une liste de personnages.
     *
     * En cas de conflit (même id), remplace l'entrée existante.
     *
     * @param characters Liste des personnages à insérer/mettre à jour
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterEntity>)

    /**
     * Supprime tous les personnages de la base de données.
     */
    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacters()
}

