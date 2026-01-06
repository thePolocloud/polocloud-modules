polocloudModule {
    id = "backup-module"
    version = project.version.toString()
    moduleName = "Backup Module"
    description = "This module makes automatic backups of PoloCloud."
    author = "RECHERGG"
    mainClass = "dev.httpmarco.polocloud.modules.backup.BackupModule"
}

dependencies {
    compileOnly(libs.log4j.api)

    compileOnly(libs.polocloud.shared)
    compileOnly(libs.polocloud.proto)
    compileOnly(libs.polocloud.agent)
    compileOnly(libs.polocloud.common)
}