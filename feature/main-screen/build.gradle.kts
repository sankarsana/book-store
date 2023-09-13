plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "feature.main.screen"

dependencies {
    implementation(project(":common:navigation-graph"))
    implementation(project(":common:ui"))

    implementation(libs.activity.compose)
}
