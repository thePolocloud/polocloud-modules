package dev.httpmarco.polocloud.modules.backup.api

import dev.httpmarco.polocloud.modules.backup.model.BackupEntry
import java.nio.file.Path

interface BackupStorage {

    fun store(source: Path, targetName: String): BackupEntry

    fun delete(entryId: String)

    fun list(): List<BackupEntry>
}