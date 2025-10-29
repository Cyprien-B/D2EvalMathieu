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

// Ici j'ai supprimé les messages d'erreur dus à une version instable de l'API Gradle. Après étude des risques, cela ne pose pas de problème pour le moment.
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
