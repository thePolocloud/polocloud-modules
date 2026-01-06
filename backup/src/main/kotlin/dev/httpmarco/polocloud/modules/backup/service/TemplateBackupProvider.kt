package dev.httpmarco.polocloud.modules.backup.service

import dev.httpmarco.polocloud.modules.backup.api.BackupProvider
import dev.httpmarco.polocloud.modules.backup.api.BackupStorage
import dev.httpmarco.polocloud.modules.backup.api.BackupType
import dev.httpmarco.polocloud.modules.backup.model.BackupResult
import dev.httpmarco.polocloud.modules.backup.model.BackupTarget
import dev.httpmarco.polocloud.modules.backup.util.ZipUtil

class TemplateBackupProvider(private val storage: BackupStorage): BackupProvider {

    override fun supports(type: BackupType): Boolean = type == BackupType.TEMPLATE

    override fun createBackup(target: BackupTarget): BackupResult {
        return try {
            val zipped = ZipUtil.zipDirectory(target.sourcePath)
            val entry = storage.store(zipped, target.name)
            BackupResult.Success(entry)
        } catch (exception: Exception) {
            BackupResult.Failed("Template backup failed", exception)
        }
    }

}