@file:Suppress("DEPRECATION")

package com.logoped583st.encryption.encryption.provider

import android.content.Context
import android.security.KeyPairGeneratorSpec
import com.logoped583st.dagger_component_connector.di.Logger
import java.math.BigInteger
import java.security.KeyPairGenerator
import javax.security.auth.x500.X500Principal

internal class KeySpecProviderApiLZ23(
        private val context: Context,
        private val logger: Logger,
        private val kpGenerator: KeyPairGenerator,
) : KeySpecGenerator() {

    override fun setupSpec(alias: String) {
        val (startCert, endCert) = keyLifeTime()

        @Suppress("DEPRECATION", "still using for android <=API 21")
        val spec = KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSubject(X500Principal("CN=$alias"))
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
