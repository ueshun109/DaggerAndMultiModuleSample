package dependencies

object Dep {
    object Kotlin {
        private const val version = "1.3.50"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        private const val coroutinesVersion = "1.3.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val androidCoroutinesDispatcher = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    }

    object AndroidX {
        private const val lifecycleVersion = "2.1.0"
        private const val navigationVersion = "2.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.1.0"
        const val appCompat = "androidx.appcompat:appcompat:1.0.2"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.0.0"

        const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
        const val lifecycleVieModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val lifecycleReactive = "android.arch.lifecycle:reactivestreams:$lifecycleVersion"
        const val lifecycleCompiler = "android.arch.lifecycle:compiler:$lifecycleVersion"

        const val navigation = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    }

    object Dagger {
        private const val version = "2.24"
        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val support = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val apt = "com.google.dagger:dagger-android-processor:$version"
    }

    object Rx {
        const val android = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val kotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    }

    object Moshi {
        private const val version = "1.8.0"
        const val moshi = "com.squareup.moshi:moshi:$version"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
    }

    object Retrofit {
        private const val version = "2.6.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converter = "com.squareup.retrofit2:converter-moshi:$version"
        const val rxjava = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0"
        const val logging = "com.squareup.okhttp3:logging-interceptor:3.11.0"
    }

    object Permission {
        private const val version = "0.10.2"
        const val rx = "com.github.tbruyelle:rxpermissions:$version"
    }

    object Timber {
        private const val version = "4.7.1"
        const val timber =  "com.jakewharton.timber:timber:$version"
    }

    object Test {
        const val junit4 = "junit:junit:4.12"
        const val assertJ = "org.assertj:assertj-core:3.10.0"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:3.11.0"
    }

}