package com.jvvladimir.torrent.client.bencode

import com.dampcake.bencode.Bencode
import com.dampcake.bencode.Type
import com.jvvladimir.torrent.client.model.BencodeTorrent
import com.jvvladimir.torrent.client.utils.FileUtils
import mu.KLogging
import java.nio.file.Path

object BencodeParser {

    private val log = KLogging().logger
    private val mapper = BencodeMapper()

    fun parse(path: Path): BencodeTorrent {
        val bencode = Bencode()
        val dict = bencode.decode(FileUtils.readBytes(path), Type.DICTIONARY)
        log.debug { dict }

        return mapper.mapToBencodeTorrent(dict)
    }

}