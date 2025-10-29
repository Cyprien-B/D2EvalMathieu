package com.example.evalmathieud2.home.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evalmathieud2.home.domain.Character
import com.example.evalmathieud2.home.domain.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


interface CharactersContracts{
    /**
     * État de l'interface utilisateur pour l'écran d'accueil.
     * @property characters La liste des personnages à afficher. Liste vide par défaut pendant le chargement.
     */
    data class UIState (
        val characters: List<Character> = emptyList()
    )
}

/**
 * ViewModel pour l'écran d'accueil affichant la liste des personnages Dragon Ball.
 * @see CharactersRepository Le repository utilisé pour récupérer les personnages
 * @see CharactersContracts.UIState L'état exposé via StateFlow
 */
class HomeScreenViewModel : ViewModel(), KoinComponent {

    private val repository: CharactersRepository by inject()

    private var _statecharacters = MutableStateFlow(CharactersContracts.UIState())

    val state: StateFlow<CharactersContracts.UIState> = _statecharacters

    init {
    viewModelScope.launch(Dispatchers.IO) {
        val characters = repository.getCharacters()
        _statecharacters.update { it.copy(characters = characters) }
    }
    }
}