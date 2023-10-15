object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.2"

    object Plugins {
        const val application = "com.android.application"
        const val kotlin = "org.jetbrains.kotlin.android"
        const val hiltPlugin = "com.google.dagger.hilt.android"
        const val hiltAndroidPlugin = "dagger.hilt.android.plugin"
        const val kotlinKapt = "kapt"
        const val kotlinParcelize = "kotlin-parcelize"
        const val pluginSerialization = "plugin.serialization"
        const val kotlinAndroid = "kotlin-android"
        const val androidLib = "com.android.library"
        const val secrets = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin"
        const val playServices = "com.google.gms.google-services"
        const val firebaseCrashlytics = "com.google.firebase.crashlytics"
        const val firebasePerformance = "com.google.firebase.firebase-perf"
    }

    object Kotlin {
        private const val version = "1.6.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val jvmTarget = "17"
    }

    object Google {
        const val material = "com.google.android.material:material:1.4.0"
        const val hiltVersion = "2.44"
        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
        const val firebaseBom = "com.google.firebase:firebase-bom:32.3.1"
        const val frebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
        const val frebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val firebasePerformance = "com.google.firebase:firebase-perf-ktx"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val lifeCycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"

        object Activity {
            const val version = "1.8.0"
            const val activityCompose = "androidx.activity:activity-compose:$version"
        }

        object Compose {
            const val bom = "androidx.compose:compose-bom:2023.03.00"
            const val ui = "androidx.compose.ui:ui"
            const val graphics = "androidx.compose.ui:ui-graphics"
            const val material = "androidx.compose.material3:material3"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
            const val tooling = "androidx.compose.ui:ui-tooling"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose"
        }

        object Navigation {
            const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0-alpha10"
        }
    }

    object Coil {
        const val composeCoil = "io.coil-kt:coil-compose:1.4.0"
    }

    object Network {
        const val retrofitVersion = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val okhttpVersion = "4.11.0"
        const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:$okhttpVersion"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingIntercepter = "com.squareup.okhttp3:logging-interceptor"
    }

    object Test {
        const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val junit = "junit:junit:4.13.2"
        const val junitTestExt = "androidx.test.ext:junit:1.1.5"
        const val espressoTest = "androidx.test.espresso:espresso-core:3.5.1"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object Compiler {
        const val JVM = "17"
        const val KOTLIN_COMPILER_EXT = "1.4.3"
    }
}