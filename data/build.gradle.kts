import java.util.Properties
import java.io.FileInputStream

plugins {
    id("pearl.android.library")
    id("pearl.android.hilt")
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}

android {
    namespace = "com.example.pearl.data"
    
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "TWILIO_BASE_URL", "\"${localProperties.getProperty("TWILIO_BASE_URL") ?: ""}\"")
        buildConfigField("String", "TWILIO_SERVICE_SID", "\"${localProperties.getProperty("TWILIO_SERVICE_SID") ?: ""}\"")
        buildConfigField("String", "TWILIO_ACCOUNT_SID", "\"${localProperties.getProperty("TWILIO_ACCOUNT_SID") ?: ""}\"")
        buildConfigField("String", "TWILIO_AUTH_TOKEN", "\"${localProperties.getProperty("TWILIO_AUTH_TOKEN") ?: ""}\"")
        buildConfigField("String", "TEST_TWILIO_ACCOUNT_SID", "\"${localProperties.getProperty("TEST_TWILIO_ACCOUNT_SID") ?: ""}\"")
        buildConfigField("String", "TEST_TWILIO_AUTH_TOKEN", "\"${localProperties.getProperty("TEST_TWILIO_AUTH_TOKEN") ?: ""}\"")
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":design_system"))

    // Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)

    // Firebase
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)

    // Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
}
