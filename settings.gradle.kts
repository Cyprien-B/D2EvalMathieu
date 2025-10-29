pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

// ici j'ai supprimer les message d'erreur due a une version instable de l'api gradle apres étude des risque cela ne pose pas de problème pour le moment
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EvalMathieuD2"

include(":app")

//Core
include(":core:ui")
include(":core:domain")
include(":core:data")
include(":core:system")

//home
include(":features:home:ui")
include(":features:home:api")
include(":features:home:data")
include(":features:home:domain")
