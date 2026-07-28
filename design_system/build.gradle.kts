plugins {
    id("pearl.android.library")
    id("pearl.android.compose")
}

android {
    namespace = "com.example.pearl.design_system"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
