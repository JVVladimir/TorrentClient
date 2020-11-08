package com.jvvladimir.torrent.client

import com.jvvladimir.torrent.client.bencode.BencodeMapper
import com.jvvladimir.torrent.client.bencode.BencodeParser
import com.jvvladimir.torrent.client.utils.FileUtils.toPath
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun `contest test`() {}

    @Test
    fun `hash code equals test`() {
        val bencodeTorrent = BencodeParser.parse(path.toPath())
        val firstHashCode = BencodeMapper().mapToTorrentFile(bencodeTorrent).generalPieceHash
        val secondHashCode = BencodeMapper().mapToTorrentFile(bencodeTorrent).generalPieceHash

        Assertions
            .assertThat(firstHashCode)
            .isEqualTo(secondHashCode)
    }
}