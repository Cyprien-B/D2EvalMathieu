import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.evalmathieud2.features.home.data"
    compileSdk = 36

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget("17")
        }
    }
}

dependencies {
    implementation(project(":features:home:domain"))

    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.compose.ui)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // implementation de koin pour l'injection de dépendances
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.bundles.koin)

    // implementation de ktor pour les appels réseau
    implementation(libs.bundles.ktor)

    // implementation de Room pour la base de données locale
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)
}