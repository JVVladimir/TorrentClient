package com.jvvladimir.torrent.client

import com.jvvladimir.torrent.client.bencode.BencodeMapper
import com.jvvladimir.torrent.client.bencode.BencodeParser
import com.jvvladimir.torrent.client.model.MessageId
import com.jvvladimir.torrent.client.utils.FileUtils
import com.jvvladimir.torrent.client.utils.FileUtils.toPath
import mu.KLogging

const val path = "/home/vladimir/IdeaProjects/TorrentClient/src/main/resources/test.torrent"
val log = KLogging().logger

fun main() {
    val s = FileUtils.readString(path.toPath())
    log.debug { s }

    val bencodeTorrent = BencodeParser.parse(path.toPath())
    log.info { "\n\n${bencodeTorrent}" }
    log.info { "\n\n${BencodeMapper().mapToTorrentFile(bencodeTorrent)}" }
}