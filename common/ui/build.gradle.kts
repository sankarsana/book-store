plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "common.ui"

dependencies {
    api(libs.core.ktx)
    api(libs.lifecycle.viewmodel.compose)
}
