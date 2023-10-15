plugins {
    id(Libs.Plugins.application)
    id(Libs.Plugins.kotlin)
    id(Libs.Plugins.kotlinAndroid)
    id(Libs.Plugins.hiltAndroidPlugin)
    id(Libs.Plugins.playServices)
    id(Libs.Plugins.firebaseCrashlytics)
    id(Libs.Plugins.firebasePerformance)
    kotlin(Libs.Plugins.kotlinKapt)
}

android {
    namespace = "com.comcast.androidtest"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applictionId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = Libs.Test.androidJUnitRunner
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = Libs.Compiler.JVM
    }

    buildFeatures {
        compose = true
        android.buildFeatures.buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compiler.KOTLIN_COMPILER_EXT
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":network"))
    implementation(project(":model"))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.lifeCycleKtx)
    implementation(Libs.AndroidX.Activity.activityCompose)

    //Compose Dependencies
    implementation(platform(Libs.AndroidX.Compose.bom))
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.graphics)
    implementation(Libs.AndroidX.Compose.toolingPreview)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.viewModel)

    //Firebase
    implementation(platform(Libs.Google.firebaseBom))
    implementation(Libs.Google.frebaseAnalytics)
    implementation(Libs.Google.frebaseCrashlytics)
    implementation(Libs.Google.firebasePerformance)

    // Dependency Injections
    implementation(Libs.Google.hilt)
    kapt(Libs.Google.hiltCompiler)

    //Image loading
    implementation(Libs.Coil.composeCoil)

    //Testing
    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junitTestExt)
    androidTestImplementation(platform(Libs.AndroidX.Compose.bom))
    androidTestImplementation(Libs.Test.composeUiTest)
    debugImplementation(Libs.Test.composeUiTooling)
    debugImplementation(Libs.Test.composeUiTestManifest)
}
kapt {
    correctErrorTypes = true
}