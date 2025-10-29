package com.example.evalmathieud2.core.system

import android.content.Context
import android.media.MediaPlayer
import androidx.annotation.RawRes


/**
 * Fonction d'extension du Context pour jouer un son
 * @param soundResId L'ID de la ressource audio (depuis res/raw)
 *  *
 */
fun Context.playSound(
    @RawRes soundResId: Int
) {
    try {

        //on joue le son
        val mediaPlayer = MediaPlayer.create(this, soundResId)

        //si ca a marché on libére les ressources
        mediaPlayer?.apply {
            setOnCompletionListener {
                it.release()
            }
            start()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
