pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "polocloud-modules"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("rest")
include("example")