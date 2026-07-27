import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    id("kotlin-parcelize")
    alias(libs.plugins.google.services)
    alias(libs.plugins.kotlin.compose)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}

android {
    namespace = "com.example.pearl"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.pearl"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.messaging)

    implementation(libs.xMaterialccp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    //SMSRetrieval API Dependencies for Auto OTP Verification
    implementation(libs.play.services.auth.api.phone)
    implementation(libs.play.services.auth)

    //Splash Api
    implementation(libs.androidx.core.splashscreen)

    //Compose Navigation
    implementation(libs.androidx.navigation.compose)

    //Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    //Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    //Arrow
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    //Datastore
    implementation(libs.androidx.datastore.preferences)

    //Proto Datastore
    implementation(libs.protobuf.javalite)

    //Accompanist
    implementation(libs.accompanist.systemuicontroller)

    //Paging 3
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    //Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
}
