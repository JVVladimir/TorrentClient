package com.jvvladimir.torrent.client.model

// TODO: переписать toString для массива
data class TorrentFile (
    val announce: String,
    val length: Long,
    val name: String,
    val pieceLength: Long,
    val generalPieceHash: ByteArray,
    val pieceHashes: List<ByteArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TorrentFile

        if (announce != other.announce) return false
        if (length != other.length) return false
        if (name != other.name) return false
        if (pieceLength != other.pieceLength) return false
        if (!generalPieceHash.contentEquals(other.generalPieceHash)) return false
        if (pieceHashes != other.pieceHashes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = announce.hashCode()
        result = 31 * result + length.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + pieceLength.hashCode()
        result = 31 * result + generalPieceHash.contentHashCode()
        result = 31 * result + pieceHashes.hashCode()
        return result
    }
}