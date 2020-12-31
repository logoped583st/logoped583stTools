package com.logoped583st.encryption.encryption.key_generator

import android.content.Context
import com.logoped583st.encryption.encryption.KEYSTORE_PROVIDER_ANDROID
import com.logoped583st.encryption.encryption.TYPE_RSA
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.util.*

abstract class RSAKeyProvider(private val ks: KeyStore) {

    protected val kpGenerator by lazy { KeyPairGenerator.getInstance(TYPE_RSA, KEYSTORE_PROVIDER_ANDROID) }

    protected fun createRSAKeys(context: Context) {
        val privateKey = ks.getKey(RSAKeyGenerator.KEY_ALIAS, null)
        if (privateKey == null) {
            createKey()
        }
    }

    protected fun keyLifeTime(): Pair<Calendar, Calendar> {
        val start = Calendar.getInstance()
        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 5)

        return Pair(start, end)
    }

    abstract fun createKey()
}
