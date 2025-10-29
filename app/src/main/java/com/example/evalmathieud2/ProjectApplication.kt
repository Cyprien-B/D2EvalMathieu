package com.example.evalmathieud2

import android.app.Application
import com.example.evalmathieud2.home.charactersModule
import org.koin.core.context.startKoin

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                charactersModule
            )
        }
    }
}

