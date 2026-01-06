package dev.httpmarco.polocloud.modules.backup.model

import java.time.Instant

data class BackupEntry(
    val id: String,
    val targetName: String,
    val createdAt: Instant,
    val sizeBytes: Long,
    val checksum: String?
)