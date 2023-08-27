plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {

    plugins {

        register("AndroidApplicationPlugin") {
            id = "android-application-plugin"
            implementationClass = "plugin.AndroidApplicationPlugin"
            displayName = "Android Application Plugin"
        }

        register("AndroidLibraryPlugin") {
            id = "android-library-plugin"
            implementationClass = "plugin.AndroidLibraryPlugin"
            displayName = "Android Library Plugin"
        }

        register("ComposePlugin") {
            id = "compose-plugin"
            implementationClass = "plugin.ComposePlugin"
            displayName = "Compose Plugin"
        }
    }
}
