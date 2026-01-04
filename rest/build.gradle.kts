import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

polocloudModule {
    id = "rest-api-module"
    version = "3.0.0-pre.8-SNAPSHOT"
    moduleName = "REST API Module"
    description = "This module exposes a REST API by default on Port 8080"
    author = "RECHERGG"
    mainClass = "dev.httpmarco.polocloud.modules.rest.RestModule"
}

dependencies {
    compileOnly(libs.polocloud.shared)
    compileOnly(libs.polocloud.proto)
    compileOnly(libs.polocloud.agent)
    compileOnly(libs.polocloud.common)

    compileOnly(libs.gson)
    implementation(libs.javalin)
    implementation(libs.javalin.ssl)

    implementation(libs.bundles.jwt)
    implementation(libs.argon2)
    compileOnly(libs.log4j.api)
}

tasks.named<ShadowJar>("shadowJar") {
    dependsOn(tasks.named("buildModule"))

    val jarTask = tasks.named<Jar>("jar").get()
    from(jarTask.archiveFile.map { zipTree(it) })
}
