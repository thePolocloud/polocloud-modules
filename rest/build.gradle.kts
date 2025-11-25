dependencies {
    compileOnly(libs.polocloud.shared)
    compileOnly(libs.polocloud.proto)

    implementation(libs.gson)
    implementation(libs.javalin)
    implementation(libs.javalin.ssl)

    implementation(libs.bundles.jwt)
    implementation(libs.argon2)
}

tasks.jar {
    dependsOn(tasks.shadowJar)
}
