package dev.httpmarco.polocloud.modules.backup.storage

import dev.httpmarco.polocloud.modules.backup.api.BackupStorage
import dev.httpmarco.polocloud.modules.backup.model.BackupEntry
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.time.Instant
import java.util.UUID

class LocalBackupStorage(private val basePath: Path) : BackupStorage {

    override fun store(
        source: Path,
        targetName: String
    ): BackupEntry {
        Files.createDirectories(basePath)

        val id = UUID.randomUUID().toString()
        val targetFile = basePath.resolve("$targetName-$id.zip")

        Files.move(source, targetFile, StandardCopyOption.REPLACE_EXISTING)

        return BackupEntry(
            id = id,
            targetName = targetName,
            createdAt = Instant.now(),
            sizeBytes = Files.size(targetFile),
            checksum = null
        )
    }

    override fun delete(entryId: String) {
        Files.list(basePath)
            .filter { it.fileName.toString().contains(entryId) }
            .forEach(Files::delete)
    }

    override fun list(): List<BackupEntry> {
        return emptyList()
    }
}