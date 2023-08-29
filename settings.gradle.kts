pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("gradle/plugins")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BookStore"
include(":app")
include(":common:navigation")
include(":common:navigation-graph")
include(":common:ui-theme")
include(":feature:main-screen")
include(":feature:store")
