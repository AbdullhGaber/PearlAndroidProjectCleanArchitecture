import org.gradle.api.artifacts.VersionCatalogsExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.ApplicationExtension

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

pluginManager.withPlugin("com.android.application") {
    extensions.configure<ApplicationExtension> {
        buildFeatures {
            compose = true
        }
    }
}

pluginManager.withPlugin("com.android.library") {
    extensions.configure<LibraryExtension> {
        buildFeatures {
            compose = true
        }
    }
}

dependencies {
    val bom = platform(libs.findLibrary("androidx-compose-bom").get())
    "implementation"(bom)
    "implementation"(libs.findLibrary("androidx-compose-ui").get())
    "implementation"(libs.findLibrary("androidx-compose-ui-graphics").get())
    "implementation"(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
    "implementation"(libs.findLibrary("androidx-compose-material3").get())
    "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling").get())
}
