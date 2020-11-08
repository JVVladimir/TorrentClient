package com.jvvladimir.torrent.client.model

data class TorrentFile (
    val announce: String,
    val length: Long,
    val name: String,
    val pieceLength: Long,
    val generalPieceHash: Int,
    val pieceHashes: List<Int>
)