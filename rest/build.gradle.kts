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

tasks.jar {
    dependsOn(tasks.shadowJar)
}
