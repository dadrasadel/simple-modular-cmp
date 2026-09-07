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

rootProject.name = "simple-modular-cmp"
include(":composeApp")
include(":common")
include(":domain")
include(":presentation:ui")
include(":presentation:feature:calendar")
include(":core:ui")
include(":core:data")
