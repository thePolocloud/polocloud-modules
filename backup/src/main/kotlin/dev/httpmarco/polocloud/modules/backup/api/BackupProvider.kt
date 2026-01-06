package dev.httpmarco.polocloud.modules.backup.api

import dev.httpmarco.polocloud.modules.backup.model.BackupResult
import dev.httpmarco.polocloud.modules.backup.model.BackupTarget

interface BackupProvider {

    fun supports(type: BackupType): Boolean

    fun createBackup(target: BackupTarget): BackupResult
}