package com.jvvladimir.torrent.client.model

enum class MessageId {
    MSG_CHOKE,
    MSG_UN_CHOKE,
    MSG_INTERESTED,
    MSG_NOT_INTERESTED,
    MSG_HAVE,
    MSG_BITFIELD,
    MSG_REQUEST,
    MSG_PIECE,
    MSG_CANCEL
}