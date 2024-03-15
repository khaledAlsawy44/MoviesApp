import java.util.Properties

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)

    kotlin("plugin.serialization") version ("1.9.0")
    kotlin("kapt")
}

val properties = Properties()
properties.load(project.rootProject.file("gradle.properties").inputStream())

android {
    namespace = "com.moviesapp.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val apiKey = properties.getProperty("API_KEY")
        val baseUrl = properties.getProperty("BASE_URL")
        val imageBaseUrl = properties.getProperty("IMAGES_BASE_URL")
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
        buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
        buildConfigField("String", "IMAGES_BASE_URL", "\"$imageBaseUrl\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        isCoreLibraryDesugaringEnabled = true
    }
    buildFeatures {
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":business-models"))

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.coroutines)
    implementation(libs.coroutines.android)
    implementation(libs.kotlin.json.serialization)
    implementation(libs.retrofit)
    implementation(libs.retrofit.serialization)
    implementation(libs.okHttp.interceptor)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.arrow)
    coreLibraryDesugaring(libs.desugar)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}