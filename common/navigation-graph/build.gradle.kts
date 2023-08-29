plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "common.navigation.graph"

dependencies {
    implementation(project(":common:navigation"))
    implementation(project(":feature:store"))

    implementation(libs.navigation.compose)
}
