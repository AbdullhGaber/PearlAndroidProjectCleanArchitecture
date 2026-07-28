plugins {
    id("pearl.android.library")
}

android {
    namespace = "com.example.pearl.domain"
}

dependencies {
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)
}
