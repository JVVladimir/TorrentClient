package com.jvvladimir.torrent.client.model

data class BencodeTorrent (
    val announce: String, // bencode:"announce"
    val info: BencodeInfo // bencode:"info"
)