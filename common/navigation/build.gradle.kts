plugins {
    id("android-library-plugin")
}

android.namespace = "common.navigation"

dependencies {
    implementation(libs.navigation.compose)
}
