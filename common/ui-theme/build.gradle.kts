plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "common.ui.theme"

dependencies {
    api(libs.core.ktx)
}
