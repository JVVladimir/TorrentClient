package com.jvvladimir.torrent.client.model

data class Handshake (
    val pstr: String = "BitTorrent protocol",
    val infoHash: ByteArray,
    val peerId: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Handshake

        if (pstr != other.pstr) return false
        if (!infoHash.contentEquals(other.infoHash)) return false
        if (!peerId.contentEquals(other.peerId)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pstr.hashCode()
        result = 31 * result + infoHash.contentHashCode()
        result = 31 * result + peerId.contentHashCode()
        return result
    }
}