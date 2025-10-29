# EvalMathieuD2 - Application Dragon Ball

Application Android affichant la liste des personnages de Dragon Ball, développée avec **Jetpack Compose** et suivant les principes de **Clean Architecture**.

## 📱 Fonctionnalités

- 🐉 Liste des personnages Dragon Ball via l'API [Dragon Ball API](https://dragonball-api.com)
- 🌓 Thème clair/sombre avec toggle manuel
- 📳 Vibration au clic sur un personnage
- 🔊 Son au clic sur un personnage
- 🧭 Navigation entre écrans

## 🏗️ Architecture

Le projet suit les principes de **Clean Architecture** avec une séparation claire des responsabilités :

```
app/                          # Module principal
core/                         # Modules core partagés
├── ui/                       # Composants UI réutilisables (Theme, composables)
├── system/                   # Gestionnaires natifs (vibration, son)
├── domain/                   # Logique métier core
└── data/                     # Données core

features/                     # Features modulaires
└── home/                     # Feature "Home"
    ├── ui/                   # Interface utilisateur (Screens, ViewModels)
    ├── domain/               # Modèles métier et repositories
    ├── data/                 # Implémentation data (API, DTOs, mappers)
    └── api/                  # Module d'injection de dépendances (Koin)
```

### Couches

**Domain Layer (Indépendante)**
- Modèles métier (`Character`)
- Interfaces Repository (`CharactersRepository`)
- Totalement indépendante des frameworks et librairies externes

**Data Layer**
- Implémentation des repositories (`CharactersRepositoryImpl`)
- Client HTTP Ktor pour les appels API
- DTOs et mappers pour la conversion DTO → Domain

**UI Layer (Presentation)**
- Composables Jetpack Compose
- ViewModels avec StateFlow
- Navigation Compose

## 📦 Dépendances

Gestion centralisée des versions via `gradle/libs.versions.toml` :

## 📱 Permissions

L'application demande les permissions suivantes :

- `INTERNET` - Appels API pour récupérer les personnages
- `ACCESS_NETWORK_STATE` - Vérifier l'état du réseau
- `VIBRATE` - Vibration au clic

## 🎨 Fonctionnalités natives

Le projet exploite 2 capacités natives du device :

### 1. Vibration
```kotlin
// Fonction d'extension dans core/system/VibrationManager.kt
Context.vibrate(durationMillis: Long = 3000, amplitude: Int = 155)
```
Gère la vibration compatible avec toutes les versions d'Android (API 21+).

### 2. Lecture de son
```kotlin
// Fonction d'extension dans core/system/SoundManager.kt
Context.playSound(@RawRes soundResId: Int)
```
Joue un son avec gestion automatique de la libération des ressources.

## 🔄 Cycle de vie

Le projet respecte le cycle de vie Android avec :

- **viewModelScope** pour les coroutines liées au ViewModel
- **StateFlow** pour l'observation réactive des états
- **collectAsState()** pour la conversion Flow → State dans Compose
- Annulation automatique des coroutines à la destruction du ViewModel

Exemple dans `HomeScreenViewModel` :
```kotlin
init {
    viewModelScope.launch(Dispatchers.IO) {
        val characters = repository.getCharacters()
        _state.update { it.copy(characters = characters) }
    }
}
```

## 🧪 Structure du code

### Pattern MVVM
- **Model** : Entités du domain (`Character`)
- **View** : Composables (`HomeScreen`, `CharacterRow`)
- **ViewModel** : Gestion de l'état (`HomeScreenViewModel`)

### Mapping DTO → Domain
Les données de l'API (DTOs) sont converties en modèles métier :
```kotlin
CharacterMapper.toCharacter(dto: CharacterDto): Character
```

### Injection de dépendances (Koin)
Configuration dans `features/home/api/CharactersModules.kt` :
```kotlin
val charactersModule = module {
    single { DragonBallApiClient() }
    single<CharactersRepository> { CharactersRepositoryImpl(get()) }
}
```

## 📝 Conventions de code

- **KDoc** pour tous les composants publics
- **Noms explicites** pour les fonctions et variables
- **Séparation des responsabilités** (Single Responsibility Principle)
- **Principes SOLID** respectés
- **Clean Architecture** appliquée

## 🌐 API utilisée

**Dragon Ball API** - https://dragonball-api.com/api

Endpoint utilisé :
```
GET /api/characters?page=1&limit=10
```

Readme générée avec ChatGPT 
