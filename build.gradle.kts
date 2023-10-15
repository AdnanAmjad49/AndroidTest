// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Libs.Plugins.application) version "8.1.2" apply false
    id(Libs.Plugins.kotlin) version "1.8.10" apply false
    id(Libs.Plugins.hiltPlugin) version "2.44" apply false
    id(Libs.Plugins.secrets) version "2.0.1" apply false
    id(Libs.Plugins.playServices) version "4.4.0" apply false
    id(Libs.Plugins.firebaseCrashlytics) version "2.9.9" apply false
    id(Libs.Plugins.firebasePerformance) version "1.4.2" apply false
    kotlin(Libs.Plugins.pluginSerialization) version "1.8.10" apply false
}