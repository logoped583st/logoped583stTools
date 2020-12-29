package com.logoped583st.encryption.encryption

interface ByteEncryption {
    fun encrypt(byteArray: ByteArray): ByteArray

    fun decrypt(byteArray: ByteArray): ByteArray
}