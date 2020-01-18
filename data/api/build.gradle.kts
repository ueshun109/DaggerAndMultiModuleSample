import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(26)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to  listOf("*.jar")))

    // Kotlin
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Kotlin.androidCoroutinesDispatcher)

    // AndroidX
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)

    // Dagger2
    implementation(Dep.Dagger.dagger)
    implementation(Dep.Dagger.support)
    kapt(Dep.Dagger.compiler)

    // Moshi
    implementation(Dep.Moshi.moshi)
    implementation(Dep.Moshi.kotlin)

    // Retrofit
    implementation(Dep.Retrofit.retrofit)
    implementation(Dep.Retrofit.converter)
    implementation(Dep.Retrofit.logging)

    // Test
    testImplementation(Dep.Test.junit4)
    testImplementation(Dep.Test.assertJ)
}
