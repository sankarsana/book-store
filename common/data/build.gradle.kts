plugins {
    id("android-library-plugin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android.namespace = "common.data"

dependencies {
    implementation(libs.okHttp)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.serialization.json)
    implementation(libs.serialization.converter)
}
