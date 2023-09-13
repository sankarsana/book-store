plugins {
    id("android-application-plugin")
}

android {
    namespace = libs.versions.applicationId.get()

    defaultConfig {
        applicationId = libs.versions.applicationId.get()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
        testInstrumentationRunner = libs.versions.testInstrumentationRunner.get()
    }
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion =
        libs.versions.kotlinCompilerExtension.get()

    buildTypes {
        release {
            isMinifyEnabled = true
            val files = getDefaultProguardFile("proguard-android-optimize.txt")
            proguardFiles(files, "proguard-rules.pro")
        }
    }

    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

dependencies {
    implementation(project(":common:ui"))
    implementation(project(":feature:main-screen"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.material3)

    testImplementation(libs.junit)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
