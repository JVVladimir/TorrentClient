package com.jvvladimir.torrent.client.utils

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption.*

object FileUtils {

    fun readFile(path: Path): String = Files.readString(path, StandardCharsets.ISO_8859_1)

    fun writeToFile(path: Path, bytes: ByteArray) {
        Files.write(path, bytes, CREATE_NEW, APPEND, WRITE)
    }

    fun String.toPath(): Path = Path.of(this)
}