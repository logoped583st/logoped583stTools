package com.logoped583st.encryption.encryption.provider

import android.annotation.TargetApi
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.StrongBoxUnavailableException
import com.logoped583st.dagger_component_connector.di.Logger
import java.math.BigInteger
import java.security.KeyPairGenerator
import javax.crypto.KeyGenerator
import javax.security.auth.x500.X500Principal

internal class KeySpecProviderApiGZ23(
        private val logger: Logger,
        private val kpGenerator: KeyGenerator,
) : KeySpecGenerator() {

    @TargetApi(Build.VERSION_CODES.P)
    override fun setupSpec(alias: String) {
        val (startCert, endCert) = keyLifeTime()

        val specBuilder = KeyGenParameterSpec.Builder(alias, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
                .setCertificateSubject(X500Principal("CN=$alias"))
                .setDigests(KeyProperties.DIGEST_SHA256)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .setKeySize(256)
                .setCertificateSerialNumber(BigInteger.valueOf(1))
                .setCertificateNotBefore(startCert.time)
                .setCertificateNotAfter(endCert.time)
                .setRandomizedEncryptionRequired(false)
                .setIsStrongBoxBacked(true)
        try {
            kpGenerator.init(specBuilder.build())
            kpGenerator.generateKey()
        } catch (se: StrongBoxUnavailableException) {
            specBuilder.setIsStrongBoxBacked(false)
            kpGenerator.init(specBuilder.build())
            kpGenerator.generateKey()
        } catch (e: Exception) {
            logger.exceptionLog(e)
            throw e
        }
    }

}
