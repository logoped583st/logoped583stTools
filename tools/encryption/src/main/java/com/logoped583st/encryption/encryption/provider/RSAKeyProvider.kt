package com.logoped583st.encryption.encryption.provider

import java.security.KeyStore
import java.security.PrivateKey
import java.security.PublicKey

internal interface RSAKeyProvider {

    fun getPrivateKey(alias: String): PrivateKey

    fun getPublicKey(alias: String): PublicKey

}

internal class RSAKeyProviderImpl(
        private val ks: KeyStore,
        private val keyGenerator: KeySpecGenerator
) : RSAKeyProvider {

    override fun getPrivateKey(alias: String): PrivateKey {
        return ((ks.getKey(alias, null) ?: run {
            keyGenerator.setupSpec(alias)
            ks.getKey(alias, null)
        }
        ?: throw (Exception("No key found under alias: $alias") as? PrivateKey
                ?: throw Exception("Not an instance of a PrivateKey")) as Throwable) as PrivateKey)

    }

    override fun getPublicKey(alias: String): PublicKey {
        val cert = ks.getCertificate(alias) ?: run {
            keyGenerator.setupSpec(alias)
            ks.getCertificate(alias)
        } ?: throw Exception("No certificate found under alias: $alias")

        return cert.publicKey ?: throw Exception("No key found under alias: $alias")
    }

}
