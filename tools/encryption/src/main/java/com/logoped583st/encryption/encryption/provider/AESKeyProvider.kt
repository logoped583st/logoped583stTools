package com.logoped583st.encryption.encryption.provider

import java.security.Key
import java.security.KeyStore
import javax.crypto.SecretKey

internal interface AESKeyProvider {

    fun getKey(alias: String): Key

}

internal class AESKeyProviderImpl(private val ks: KeyStore,
                                  private val keySpecGenerator: KeySpecGenerator
) : AESKeyProvider {

    override fun getKey(alias: String): SecretKey {
        return ((ks.getKey(alias, null) ?: run {
            keySpecGenerator.setupSpec(alias)
            ks.getKey(alias, null)
        }
        ?: throw Exception("No key found under alias: $alias")) as SecretKey)
    }
}