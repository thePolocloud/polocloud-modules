package dev.httpmarco.polocloud.modules.backup.model

sealed class BackupResult {
    data class Success(val entry: BackupEntry) : BackupResult()
    data class Failed(val reason: String, val throwable: Throwable? = null) : BackupResult()
}