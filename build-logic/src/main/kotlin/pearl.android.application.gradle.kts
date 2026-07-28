import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion

pluginManager.apply("org.jetbrains.kotlin.android")
plugins {
    id("com.android.application")
}

extensions.configure<ApplicationExtension> {
    compileSdk = 37

    defaultConfig {
        minSdk = 26
        targetSdk = 37
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
