package dev.httpmarco.polocloud.modules.backup.util

import java.nio.file.Files
import java.nio.file.Path
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object ZipUtil {

    fun zipDirectory(sourceDir: Path): Path {
        val zipPath = Files.createTempFile("backup-", ".zip")

        ZipOutputStream(Files.newOutputStream(zipPath)).use { zip ->
            Files.walk(sourceDir).filter { Files.isRegularFile(it) }.forEach { path ->
                val entry = ZipEntry(sourceDir.relativize(path).toString())
                zip.putNextEntry(entry)
                Files.copy(path, zip)
                zip.closeEntry()
            }
        }

        return zipPath
    }
}