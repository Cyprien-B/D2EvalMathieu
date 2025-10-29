package com.example.evalmathieud2.home.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.evalmathieud2.core.system.playSound
import com.example.evalmathieud2.core.system.vibrate
import com.example.evalmathieud2.core.ui.R

/**
 * ViewModel pour gérer les interactions d'un personnage (son et vibration).
 */
class CharacterRowViewModel : ViewModel() {

    /**
     * Gère le clic sur un personnage : déclenche le son et la vibration.
     *
     * @param context Le contexte Android pour jouer le son et vibrer.
     * @param onNavigate Action de navigation à exécuter après les effets.
     */
    fun handleCharacterClick(context: Context, onNavigate: () -> Unit) {
        context.playSound(R.raw.ding)
        context.vibrate()
        onNavigate()
    }
}

