package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("UNUSED")
internal class ComposePlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {

        androidLibrary {
            buildFeatures.compose = true
            composeOptions.kotlinCompilerExtensionVersion =
                libs.versions.kotlinCompilerExtension.get()
        }

        dependencies {
            "implementation"(libs.ui)
            "implementation"(libs.ui.graphics)
            "implementation"(libs.ui.tooling)
            "implementation"(platform(libs.compose.bom))

            "implementation"(libs.material3)
            "compileOnly"(libs.ui.tooling.preview)
        }
    }
}
