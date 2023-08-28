plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "feature.main.screen"

dependencies {
    implementation(project(":common:ui-theme"))

    implementation(libs.activity.compose)
}
