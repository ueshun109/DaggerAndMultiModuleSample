import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}
apply(from = rootProject.file("gradle/common.gradle"))

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(project("path" to ":data:api"))

    // Kotlin
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Kotlin.androidCoroutinesDispatcher)
}