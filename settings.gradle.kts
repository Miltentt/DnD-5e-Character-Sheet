pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "DnD 5e Character Sheet"
include(":app")
include(":core")
include(":database")
include("common-config.gradle.kts")
include(":domain")
include(":resources")
include(":featureDashboard")
include(":designSystem")
include(":featureCharacterCreation")
include(":featureCardBase")
