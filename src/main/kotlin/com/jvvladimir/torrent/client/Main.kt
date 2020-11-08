package com.jvvladimir.torrent.client

import com.jvvladimir.torrent.client.utils.FileUtils
import com.jvvladimir.torrent.client.utils.FileUtils.toPath
import mu.KLogging

const val path = "/home/vladimir/IdeaProjects/TorrentClient/src/main/resources/test.torrent"
val log = KLogging().logger

fun main() {
    val s = FileUtils.readFile(path.toPath())
    log.info { s }
}