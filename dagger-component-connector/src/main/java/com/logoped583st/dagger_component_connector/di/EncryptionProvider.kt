package com.logoped583st.dagger_component_connector.di

interface EncryptionProvider {
    fun provideEncryption(): Encryption
}

interface Encryption {

    fun encrypt(string: String): String

    fun decrypt(string: String): String
}