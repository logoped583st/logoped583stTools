package com.logoped583st.encryption.encryption.key_generator

import android.content.Context
import android.os.Build
import java.security.KeyStore
import java.security.PrivateKey
import java.security.PublicKey
import java.util.*
import javax.inject.Inject

class RSAKeyGenerator @Inject constructor() {

    companion object {
        const val KEYSTORE_PROVIDER_ANDROID: String = "AndroidKeyStore"

        const val KEY_ALIAS = "KEY_ALIAS"
    }

    private val ks = KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID)

    init {
        ks.load(null, null)
    }

    fun getPrivateKey(): PrivateKey {
        return (ks.getKey(KEY_ALIAS, null)
                ?: throw Exception("No key found under alias: $KEY_ALIAS")) as? PrivateKey
                ?: throw Exception("Not an instance of a PrivateKey")
    }

    fun getPublicKey(): PublicKey {
        val cert = ks.getCertificate(KEY_ALIAS)
                ?: throw Exception("No certificate found under alias: $KEY_ALIAS")

        return cert.publicKey ?: throw Exception("No key found under alias: $KEY_ALIAS")
    }

}