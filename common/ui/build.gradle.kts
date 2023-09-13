plugins {
    id("android-library-plugin")
    id("compose-plugin")
}

android.namespace = "common.ui"

dependencies {
    api(project("::common:ui-theme"))

    api(libs.lifecycle.viewmodel.compose)
}
