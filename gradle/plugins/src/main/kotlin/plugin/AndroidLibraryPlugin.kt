package plugin

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

@Suppress("UNUSED")
internal class AndroidLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {

        plugins.run {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }

        androidLibrary {
            compileSdk = libs.versions.compileSdk.get().toInt()
            defaultConfig {
                minSdk = libs.versions.minSdk.get().toInt()
                targetSdk = libs.versions.targetSdk.get().toInt()
                vectorDrawables.useSupportLibrary = true
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }
        }
    }

    private fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>) {
        return (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
    }
}
