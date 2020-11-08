package com.jvvladimir.torrent.client

import com.jvvladimir.torrent.client.bencode.BencodeMapper
import com.jvvladimir.torrent.client.bencode.BencodeParser
import com.jvvladimir.torrent.client.service.RequestService
import com.jvvladimir.torrent.client.utils.FileUtils
import com.jvvladimir.torrent.client.utils.FileUtils.toPath
import mu.KLogging
import org.apache.commons.lang3.SerializationUtils
import java.io.DataOutputStream
import java.io.Serializable
import java.nio.ByteBuffer

const val path = "/home/vladimir/IdeaProjects/TorrentClient/src/main/resources/test.torrent"
val log = KLogging().logger

fun main() {
    val c = Cat(2,7)
    println(SerializationUtils.serialize(Cat(2,4)).size)
    val b: ByteBuffer = ByteBuffer.allocate(4)
    b.putShort(c.a)
    b.putShort(c.b)
    println(b)
    b.flip()
    println(b.getShort(0))
    println(b.getShort(2))

    val s = FileUtils.readString(path.toPath())
    log.debug { s }

    val bencodeTorrent = BencodeParser.parse(path.toPath())
    // log.info { "\n\n${bencodeTorrent}" }
    val torrentFile = BencodeMapper().mapToTorrentFile(bencodeTorrent)
    log.info { "\n\n$torrentFile" }
    RequestService().performRequestToPeer(torrentFile)
}

class Cat(i: Short, i1: Short) : Serializable {
    val a: Short = i
    val b: Short = i1
}