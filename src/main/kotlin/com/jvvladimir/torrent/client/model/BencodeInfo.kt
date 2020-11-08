package com.jvvladimir.torrent.client.model

// TODO: изменить коменты!
data class BencodeInfo (
    val name: String, // bencode:"name"
    val length: Long, // bencode:"length"
    val pieceLength: Long, // bencode:"piece length"
    val pieces: String // bencode:"pieces"
)