package com.logoped583st.encryption.encryption.key_generator

import android.content.Context
import android.security.KeyPairGeneratorSpec
import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.encryption.encryption.KEY_ALIAS
import java.math.BigInteger
import java.security.KeyStore
import javax.security.auth.x500.X500Principal

class RSAProviderApiLZ23(
        private val context: Context,
        private val logger: Logger,
        ks: KeyStore
) : RSAKeyProvider(ks) {

    @Suppress("deprecated")
    override fun createKey() {
        val (startCert, endCert) = keyLifeTime()

        val spec = KeyPairGeneratorSpec.Builder(context)
                .setAlias(KEY_ALIAS)
                .setSubject(X500Principal("CN=$KEY_ALIAS"))
                .setSerialNumber(BigInteger.valueOf(1))
                .setStartDate(startCert.time)
                .setEndDate(endCert.time)
                .build()

        try {
            kpGenerator.initialize(spec)
            kpGenerator.generateKeyPair()
        } catch (e: Exception) {
            logger.exceptionLog(e)
        }
    }
}
