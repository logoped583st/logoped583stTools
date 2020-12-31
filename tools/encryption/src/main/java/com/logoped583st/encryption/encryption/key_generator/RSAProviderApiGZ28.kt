package com.logoped583st.encryption.encryption.key_generator

import android.annotation.TargetApi
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.StrongBoxUnavailableException
import com.logoped583st.encryption.encryption.KEY_ALIAS
import java.math.BigInteger
import java.security.KeyStore
import javax.security.auth.x500.X500Principal

class RSAProviderApiGZ28(ks: KeyStore) : RSAKeyProvider(
        ks
) {
    @TargetApi(Build.VERSION_CODES.P)
    override fun createKey() {
        val (startCert, endCert) = keyLifeTime()

        val specBuilder = KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
                .setCertificateSubject(X500Principal("CN=$KEY_ALIAS"))
                .setDigests(KeyProperties.DIGEST_SHA256)
                .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                .setCertificateSerialNumber(BigInteger.valueOf(1))
                .setCertificateNotBefore(startCert.time)
                .setCertificateNotAfter(endCert.time)
                .setIsStrongBoxBacked(true)
        try {
            kpGenerator.initialize(specBuilder.build())
            kpGenerator.generateKeyPair()
        } catch (se: StrongBoxUnavailableException) {
            specBuilder.setIsStrongBoxBacked(false)
            kpGenerator.initialize(specBuilder.build())
            kpGenerator.generateKeyPair()
        }
    }

}
