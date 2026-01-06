package dev.httpmarco.polocloud.modules.backup.service

import dev.httpmarco.polocloud.modules.backup.api.BackupProvider
import dev.httpmarco.polocloud.modules.backup.api.BackupStorage
import dev.httpmarco.polocloud.modules.backup.api.BackupType
import dev.httpmarco.polocloud.modules.backup.model.BackupResult
import dev.httpmarco.polocloud.modules.backup.model.BackupTarget
import dev.httpmarco.polocloud.modules.backup.util.ZipUtil

class ServiceBackupProvider(private val storage: BackupStorage): BackupProvider {

    override fun supports(type: BackupType): Boolean =
        type == BackupType.SERVICE

    override fun createBackup(target: BackupTarget): BackupResult {
        return try {
            val archive = ZipUtil.zipDirectory(target.sourcePath)
            val entry = storage.store(archive, target.name)
            BackupResult.Success(entry)
        } catch (exception: Exception) {
            BackupResult.Failed("Service backup failed", exception)
        }
    }
}