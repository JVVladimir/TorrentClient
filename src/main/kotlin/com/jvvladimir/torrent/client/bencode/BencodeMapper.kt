package com.jvvladimir.torrent.client.bencode

import com.jvvladimir.torrent.client.model.BencodeInfo
import com.jvvladimir.torrent.client.model.BencodeTorrent
import com.jvvladimir.torrent.client.model.TorrentFile
import com.jvvladimir.torrent.client.utils.DigestUtils

class BencodeMapper {

    fun mapToBencodeTorrent(dict: Map<String, Any>): BencodeTorrent {
        val info = dict["info"] as Map<*, *>
        val bencodeInfo = BencodeInfo(
            info["name"] as String,
            info["length"] as Long,
            info["piece length"] as Long,
            info["pieces"] as String
        )

        return BencodeTorrent(dict["announce"] as String, bencodeInfo)
    }

    fun mapToTorrentFile(bencodeTorrent: BencodeTorrent): TorrentFile {
        val bytes = bencodeTorrent.info.pieces.encodeToByteArray()
        val listOfArrays = mutableListOf<ByteArray>()
        var tempArray = ByteArray(20)
        var j = 0
        for (i in bytes.indices) {
            if (i % 20 == 0) {
                listOfArrays.add(tempArray)
                tempArray = ByteArray(20)
                j = 0
            }
            tempArray[j] = bytes[i]
            j++
        }

        return TorrentFile(
            name = bencodeTorrent.info.name,
            length = bencodeTorrent.info.length,
            pieceLength = bencodeTorrent.info.pieceLength,
            announce = bencodeTorrent.announce,
            generalPieceHash = DigestUtils.sha1(listOfArrays),
            pieceHashes = listOfArrays
        )
    }
}