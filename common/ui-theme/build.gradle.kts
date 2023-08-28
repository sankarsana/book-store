plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "common.ui.theme"

dependencies {
    implementation(libs.core.ktx)
}
