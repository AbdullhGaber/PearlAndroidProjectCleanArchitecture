import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion

pluginManager.apply("org.jetbrains.kotlin.android")
plugins {
    id("com.android.library")
}

extensions.configure<LibraryExtension> {
    compileSdk = 37

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


}
