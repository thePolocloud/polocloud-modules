package dev.httpmarco.polocloud.modules.backup.config

import java.time.Duration

data class BackupConfig(
    val enabled: Boolean = true,
    val retentionCount: Int = 10,
    val backupInterval: Duration = Duration.ofHours(6),
    val backupPath: String = "backups/"
)