plugins {
    id("pearl.android.library")
    id("pearl.android.compose")
    id("pearl.android.hilt")
}

android {
    namespace = "com.example.pearl.presentation"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":design_system"))

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.hilt.navigation.compose)

    // Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    // Material Icons Extended
    implementation(libs.androidx.compose.material.icons.extended)

    // Accompanist
    implementation(libs.accompanist.systemuicontroller)

    // Paging
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    // xMaterialccp (phone country code picker)
    implementation(libs.xMaterialccp)

    // Firebase (used by some ViewModels)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)

    // Arrow
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)
}
