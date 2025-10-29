package com.example.evalmathieud2

import android.app.Application
import com.example.evalmathieud2.home.charactersModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Classe Application pour l'injection de dépendances Koin.
 * L'injection est déportée ici pour éviter de perdre les dépendances injectées
 * lors de la réinitialisation du cycle de vie de MainActivity.
 */
class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ProjectApplication)
            modules(
                charactersModule
            )
        }
    }
}
