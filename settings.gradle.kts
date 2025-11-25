plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "polocloud-modules"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("rest")
include("example")