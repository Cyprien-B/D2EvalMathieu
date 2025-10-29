package com.example.evalmathieud2.core.system

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

/**
 * Fonction d'extension pour faire vibrer le téléphone
 * @param durationMillis Durée de la vibration en millisecondes (par défaut 3000ms = 3 secondes)
 * @param amplitude Amplitude de la vibration (1-255, par défaut 255 = max)
 *
 *
 */

// Il m'arrive d'avoir une erreur sur les permissions, mais je n'arrive pas à la reproduire systématiquement mais
//  crée un manifest dans ce module avec les autorisation reglera le probléme. l'erreur a disparu de mon ide donc
// je prefere ne pas l'ajouter pour le moment
fun Context.vibrate(durationMillis: Long = 3000, amplitude: Int = 255) {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        // Android 12 et supérieur
        val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
        vibratorManager?.defaultVibrator
    } else {
        // Android 11 et inférieur
        @Suppress("DEPRECATION")
        getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }

    vibrator?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Android 8.0 et supérieur
            val effect = VibrationEffect.createOneShot(durationMillis, amplitude)
            it.vibrate(effect)
        } else {
            // Android 7.1 et inférieur
            @Suppress("DEPRECATION")
            it.vibrate(durationMillis)
        }
    }
}
