plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
    alias(libs.plugins.polocloud.module) apply false
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "dev.httpmarco.polocloud"
    version = "3.0.0-pre.8-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            name = "polocloud-snapshots"
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }

    kotlin {
        jvmToolchain(21)
    }
}

subprojects {
    apply(plugin = "dev.httpmarco.polocloud.module")
}