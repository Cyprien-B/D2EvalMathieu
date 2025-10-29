import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.evalmathieud2"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.evalmathieud2"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget("17")
        }
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.compose.ui)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.transportation.consumer)
    debugImplementation(libs.androidx.compose.ui.tooling)

    /** implementation des ui*/
    implementation(project(":core:ui"))
    implementation(project(":features:home:ui"))
}