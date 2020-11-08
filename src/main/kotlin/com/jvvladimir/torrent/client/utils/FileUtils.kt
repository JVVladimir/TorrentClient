package com.jvvladimir.torrent.client.utils

import com.dampcake.bencode.BencodeInputStream
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption.*

object FileUtils {

    fun readString(path: Path): String = Files.readString(path, StandardCharsets.ISO_8859_1)

    fun readBencode(path: Path): BencodeInputStream = BencodeInputStream(ByteArrayInputStream(Files.readAllBytes(path)), StandardCharsets.ISO_8859_1)

    fun readBytes(path: Path): ByteArray = Files.readAllBytes(path)

    fun writeToFile(path: Path, bytes: ByteArray) {
        Files.write(path, bytes, CREATE_NEW, APPEND, WRITE)
    }

    fun String.toPath(): Path = Path.of(this)
}