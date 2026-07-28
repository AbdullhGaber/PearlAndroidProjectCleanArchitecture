import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    "implementation"(libs.findLibrary("hilt-android").get())
    "ksp"(libs.findLibrary("hilt-compiler").get())
}
