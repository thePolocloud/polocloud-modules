import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.3.0"
    id("com.gradleup.shadow") version "9.2.2"
    id("dev.httpmarco.polocloud.module") version "3.0.0-pre.8-SNAPSHOT" apply false
}

group = "dev.httpmarco.polocloud"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.gradleup.shadow")
    apply(plugin = "dev.httpmarco.polocloud.module")

    group = "dev.httpmarco.polocloud"
    version = "3.0.0-pre.7-SNAPSHOT"

    repositories {
        mavenCentral()
        maven {
            name = "polocloud-snapshots"
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }

    tasks.withType<ShadowJar> {
        archiveFileName.set("polocloud-${project.name}-$version.jar")
    }

    kotlin {
        jvmToolchain(21)
    }
}