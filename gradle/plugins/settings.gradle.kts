dependencyResolutionManagement {
    defaultLibrariesExtensionName.set("projectLibs")
    versionCatalogs {
        register("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}
