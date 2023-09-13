plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "feature.store"

dependencies {
    implementation(project(":common:ui"))
}
