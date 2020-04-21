import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
apply(from = rootProject.file("gradle/common.gradle"))

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(project("path" to ":model"))
    implementation(project("path" to ":data:api"))

    // Kotlin
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Kotlin.androidCoroutinesDispatcher)

    // Dagger
    implementation(Dep.Dagger.dagger)
    kapt(Dep.Dagger.compiler)

    // Moshi
    implementation(Dep.Moshi.moshi)
    implementation(Dep.Moshi.kotlin)

    // Retrofit
    implementation(Dep.Retrofit.retrofit)

    // Test
    testImplementation(Dep.Test.junit4)
    testImplementation(Dep.Test.assertJ)
    testImplementation(Dep.Test.mockWebServer)
}
