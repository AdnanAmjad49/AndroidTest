plugins {
    id(Libs.Plugins.androidLib)
    id(Libs.Plugins.kotlin)
    id(Libs.Plugins.kotlinAndroid)
    id(Libs.Plugins.secrets)
    kotlin(Libs.Plugins.kotlinKapt)
}

android {
    namespace = "com.comcast.network"
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
    // Dependency Injections
    implementation(Libs.Google.hilt)
    kapt(Libs.Google.hiltCompiler)
    //coroutines
    implementation(Libs.AndroidX.coroutine)
    //Network
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.retrofitGson)
    implementation(platform(Libs.Network.okhttpBom))
    implementation(Libs.Network.okHttp)
    implementation(Libs.Network.loggingIntercepter)
    //Testing
    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junitTestExt)

    implementation(project(":model"))
}