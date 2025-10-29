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
