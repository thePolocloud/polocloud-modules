package dev.httpmarco.polocloud.modules.backup.api

import dev.httpmarco.polocloud.modules.backup.model.BackupResult
import dev.httpmarco.polocloud.modules.backup.model.BackupTarget

class BackupManager(private val providers: List<BackupProvider>) {

    fun backup(target: BackupTarget): BackupResult {
        val provider = providers.firstOrNull { it.supports(target.type) }
            ?: return BackupResult.Failed("No provider for ${target.type}")

        return provider.createBackup(target)
    }
}