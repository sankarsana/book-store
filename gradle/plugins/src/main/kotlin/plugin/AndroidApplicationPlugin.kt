package plugin

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

@Suppress("UNUSED")
internal class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {

        plugins.run {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }

        androidApp {
            compileSdk = libs.versions.compileSdk.get().toInt()
            defaultConfig {
                minSdk = libs.versions.minSdk.get().toInt()
                targetSdk = libs.versions.targetSdk.get().toInt()
                vectorDrawables.useSupportLibrary = true
            }
            buildFeatures.buildConfig = true
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }

    private fun BaseAppModuleExtension.kotlinOptions(configure: Action<KotlinJvmOptions>) =
        (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

    private fun Project.kotlin(configure: Action<KotlinAndroidProjectExtension>) {
        extensions.configure("kotlin", configure)
    }
}
