pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MoviesApp"
include(":app")
include(":navigation")
include(":core")
include(":business-models")
include(":core:network")
include(":core:data")
include(":design-system")
include(":features:moviesList")
include(":core:common")
include(":features:movieDetails")
