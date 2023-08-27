package plugin

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

internal fun Project.androidApp(configure: Action<BaseAppModuleExtension>) {
    return extensions.configure("android", configure)
}

internal fun Project.androidLibrary(configure: Action<LibraryExtension>) {
    return extensions.configure("android", configure)
}

internal fun Project.android(configure: Action<BaseExtension>) {
    return extensions.configure("android", configure)
}

internal val Project.libs
    get() = the<LibrariesForLibs>()
