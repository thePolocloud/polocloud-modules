package dev.httpmarco.polocloud.modules.backup.api

enum class BackupType {
    TEMPLATE,

    /**
     * Static services
     */
    SERVICE,
    CONFIG
}