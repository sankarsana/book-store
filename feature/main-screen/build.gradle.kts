plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "feature.main.screen"

dependencies {
    implementation(project(":common:ui-theme"))
    implementation(project(":common:navigation-graph"))

    implementation(libs.activity.compose)
}
