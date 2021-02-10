package com.logoped583st.dagger_component_connector.di

interface EncryptionProvider {
    fun provideEncryption(): Encryption
}

interface Encryption {

    fun encryptBytes(bytes: ByteArray): ByteArray

    fun decryptBytes(bytes: ByteArray): ByteArray

}
