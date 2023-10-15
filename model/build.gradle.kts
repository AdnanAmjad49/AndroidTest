plugins {
    id(Libs.Plugins.androidLib)
    id(Libs.Plugins.kotlin)
    id(Libs.Plugins.kotlinAndroid)
    id(Libs.Plugins.secrets)
    id(Libs.Plugins.kotlinParcelize)
    kotlin(Libs.Plugins.kotlinKapt)
}

android {
    namespace = "com.comcast.model"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = Libs.Test.androidJUnitRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
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
    }
    kotlinOptions {
        jvmTarget = Libs.Kotlin.jvmTarget
    }
    buildFeatures {
        android.buildFeatures.buildConfig = true
    }
}

dependencies {
    implementation(Libs.Network.retrofitGson)
}