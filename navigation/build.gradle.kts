plugins {
    id("pearl.android.library")
    id("pearl.android.compose")
    id("pearl.android.hilt")
}

android {
    namespace = "com.example.pearl.navigation"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":presentation"))
    implementation(project(":design_system"))

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.hilt.navigation.compose)

    // Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}
