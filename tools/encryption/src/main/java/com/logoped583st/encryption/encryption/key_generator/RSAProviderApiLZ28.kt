package com.logoped583st.encryption.encryption.key_generator

import android.annotation.TargetApi
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.encryption.encryption.KEYSTORE_PROVIDER_ANDROID
import com.logoped583st.encryption.encryption.KEY_ALIAS
import com.logoped583st.encryption.encryption.TYPE_RSA
import java.math.BigInteger
import java.security.KeyPairGenerator
import java.security.KeyStore
import javax.security.auth.x500.X500Principal


class RSAProviderApiLZ28(
        private val logger: Logger,
        ks: KeyStore
) : RSAKeyProvider(ks) {

    @TargetApi(Build.VERSION_CODES.M)
    override fun createKey() {
        val (startCert, endCert) = keyLifeTime()

        val kpGenerator = KeyPairGenerator.getInstance(TYPE_RSA, KEYSTORE_PROVIDER_ANDROID)

        val spec = KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
                .setCertificateSubject(X500Principal("CN=$KEY_ALIAS"))
                .setDigests(KeyProperties.DIGEST_SHA256)
                .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                .setCertificateSerialNumber(BigInteger.valueOf(1))
                .setCertificateNotBefore(startCert.time)
                .setCertificateNotAfter(endCert.time)
                .build()

        try {
            kpGenerator.initialize(spec)
            kpGenerator.generateKeyPair()
        } catch (e: Exception) {
            logger.exceptionLog(e)
        }
    }
}