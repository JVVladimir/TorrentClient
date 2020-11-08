package com.jvvladimir.torrent.client.utils

import org.apache.commons.codec.digest.DigestUtils

object DigestUtils {

    fun sha1(listOfArrays: List<ByteArray>): ByteArray {
        // TODO: переделать сразу в массив
        val list = mutableListOf<Byte>()

        for (i in listOfArrays) {
            for (j in i) {
                list.add(j)
            }
        }

        return DigestUtils.sha1(list.toByteArray())
    }
}