package com.jvvladimir.torrent.client.service

import com.jvvladimir.torrent.client.model.TorrentFile

// TODO: https://web.archive.org/web/20170101194115/http://bittorrent.org/beps/bep_0015.html спека реализации на UDP
class UrlBuilder {

    fun buildUrl(tFile: TorrentFile, peerId: ByteArray, port: Int): String {
        val scheme = tFile.announce.substring(0, tFile.announce.indexOf(':'))
//        val url = HttpUrl.Builder()
//            .scheme(scheme)
//            .host(tFile.announce.substring(tFile.announce.indexOf("//") + 2, tFile.announce.lastIndexOf(":")))
//            .addPathSegment("/announce")
//            .addQueryParameter("info_hash", "${tFile.generalPieceHash.toByteString()}")
//            .addQueryParameter("peer_id", "${peerId.toByteString()}")
//            .addQueryParameter("port", "$port")
//            .addQueryParameter("uploaded", "0")
//            .addQueryParameter("downloaded", "0")
//            .addQueryParameter("compact", "1")
//            .addQueryParameter("left", "${tFile.length}")
//            .build()
       // return "$url"
        return ""
    }
}