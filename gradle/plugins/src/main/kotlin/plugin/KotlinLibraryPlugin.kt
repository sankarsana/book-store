package plugin

import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

@Suppress("UNUSED")
internal class KotlinLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {
        plugins.run {
            apply("java-library")
            apply("org.jetbrains.kotlin.jvm")
        }

        val javaVersion: String by project

        java {
            sourceCompatibility = JavaVersion.toVersion(javaVersion)
            targetCompatibility = JavaVersion.toVersion(javaVersion)
        }
        kotlin {
            jvmToolchain {
                languageVersion.set(JavaLanguageVersion.of(javaVersion))
            }
        }

//   From tinkoff mobile-bank-android
//        tasks.withType<KotlinCompile>().configureEach {
//            kotlinOptions.jvmTarget = javaVersion
//        }
//        tasks.withType<Test>().configureEach {
//            useJUnitPlatform()
//        }
    }

    private fun Project.java(configure: Action<JavaPluginExtension>) {
        (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("java", configure)
    }

    private fun Project.kotlin(configure: Action<KotlinJvmProjectExtension>) {
        extensions.configure("kotlin", configure)
    }
}
