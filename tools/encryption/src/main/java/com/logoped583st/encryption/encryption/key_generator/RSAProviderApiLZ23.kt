package com.logoped583st.encryption.encryption.key_generator

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.security.KeyPairGeneratorSpec
import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.encryption.encryption.KEYSTORE_PROVIDER_ANDROID
import com.logoped583st.encryption.encryption.KEY_ALIAS
import com.logoped583st.encryption.encryption.TYPE_RSA
import java.math.BigInteger
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.util.*
import javax.security.auth.x500.X500Principal

class RSAProviderApiLZ23(
        private val context: Context,
        private val logger: Logger,
        ks: KeyStore
) : RSAKeyProvider(ks) {

    @Suppress("deprecated")
    override fun createKey() {
        val start = Calendar.getInstance()
        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 25)

        val kpGenerator = KeyPairGenerator.getInstance(TYPE_RSA, KEYSTORE_PROVIDER_ANDROID)

        val spec = KeyPairGeneratorSpec.Builder(context)
                .setAlias(KEY_ALIAS)
                .setSubject(X500Principal("CN=$KEY_ALIAS"))
                .setSerialNumber(BigInteger.valueOf(1))
                .setStartDate(start.time)
                .setEndDate(end.time)
                .build()

        try {
            kpGenerator.initialize(spec)
            kpGenerator.generateKeyPair()
        } catch (e: Exception) {
            logger.exceptionLog(e)
        }
    }
}