package com.jvvladimir.torrent.client.service

import com.jvvladimir.torrent.client.model.TorrentFile
import mu.KLogging
import kotlin.random.Random

class RequestService {

    private val builder = UrlBuilder()
    private val peerId: ByteArray = Random.nextBytes(20)
    private val port: Int = Random.nextInt(30000, 65000)
    private val log = KLogging().logger

    fun performRequestToPeer(tFile: TorrentFile) {
        val url = builder.buildUrl(tFile, peerId, port)
        log.info { "$url\n" }


//        val channel: DatagramChannel = DatagramChannel.open()
//        channel.send()
    }
}