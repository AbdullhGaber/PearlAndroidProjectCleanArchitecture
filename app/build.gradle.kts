import java.util.Properties
import java.io.FileInputStream

plugins {
    id("pearl.android.application")
    id("pearl.android.compose")
    id("pearl.android.hilt")
    alias(libs.plugins.google.services)
    alias(libs.plugins.kotlin.parcelize)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}

android {
    namespace = "com.example.pearl"

    defaultConfig {
        applicationId = "com.example.pearl"
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }

        // Twilio secrets from local.properties
        buildConfigField("String", "TWILIO_BASE_URL", "\"${localProperties.getProperty("TWILIO_BASE_URL") ?: ""}\"")
        buildConfigField("String", "TWILIO_SERVICE_SID", "\"${localProperties.getProperty("TWILIO_SERVICE_SID") ?: ""}\"")
        buildConfigField("String", "TWILIO_ACCOUNT_SID", "\"${localProperties.getProperty("TWILIO_ACCOUNT_SID") ?: ""}\"")
        buildConfigField("String", "TWILIO_AUTH_TOKEN", "\"${localProperties.getProperty("TWILIO_AUTH_TOKEN") ?: ""}\"")
        buildConfigField("String", "TEST_TWILIO_ACCOUNT_SID", "\"${localProperties.getProperty("TEST_TWILIO_ACCOUNT_SID") ?: ""}\"")
        buildConfigField("String", "TEST_TWILIO_AUTH_TOKEN", "\"${localProperties.getProperty("TEST_TWILIO_AUTH_TOKEN") ?: ""}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":navigation"))
    implementation(project(":design_system"))
    
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.messaging)

    implementation(libs.play.services.auth.api.phone)
    implementation(libs.play.services.auth)

    // Retrofit (for DI)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)

    // Room (for DI)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    
    // DataStore (for DI)
    implementation(libs.androidx.datastore.preferences)
}
