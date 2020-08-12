import dependencies.Dep

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")
    defaultConfig {
        applicationId = "com.example.android.daggerandmultimodulesample"
        minSdkVersion(26)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(project("path" to ":core"))
    implementation(project("path" to ":feature:repos"))
    implementation(project("path" to ":domain:use_case"))
    implementation(project("path" to ":data:api"))
    implementation(project("path" to ":data:repository"))

    // Kotlin
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Kotlin.androidCoroutinesDispatcher)

    // AndroidX
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraintLayout)
    implementation(Dep.AndroidX.navigation)
    implementation(Dep.AndroidX.navigationUI)

    // Dagger2
    implementation(Dep.Dagger.dagger)
    implementation(Dep.Dagger.support)
    kapt(Dep.Dagger.compiler)

    // Moshi
    implementation(Dep.Moshi.moshi)
    implementation(Dep.Moshi.kotlin)

    // Retrofit
    implementation(Dep.Retrofit.logging)
}
