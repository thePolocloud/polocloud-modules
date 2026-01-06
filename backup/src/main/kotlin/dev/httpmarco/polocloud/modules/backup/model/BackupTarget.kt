package dev.httpmarco.polocloud.modules.backup.model

import dev.httpmarco.polocloud.modules.backup.api.BackupType
import java.nio.file.Path

data class BackupTarget(
    val name: String,
    val type: BackupType,
    val sourcePath: Path
)