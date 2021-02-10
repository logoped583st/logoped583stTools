package com.logoped583st.encryption.encryption

import android.annotation.TargetApi
import android.os.Build
import com.logoped583st.dagger_component_connector.di.Encryption
import com.logoped583st.encryption.encryption.provider.AESKeyProvider
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

@TargetApi(Build.VERSION_CODES.M)
internal class EncryptionApi23(
        private val keyAlias: String,
        private val cipher: Cipher,
        private val aesKeyProvider: AESKeyProvider,
) : Encryption {

    private val ivSize = 16

    private val secureRandom: SecureRandom = SecureRandom()

    @Throws(Exception::class)
    override fun encryptBytes(bytes: ByteArray): ByteArray {
        val iv = ByteArray(ivSize)
        secureRandom.nextBytes(iv)
        val ivParameterSpec = IvParameterSpec(iv)


        cipher.init(Cipher.ENCRYPT_MODE, aesKeyProvider.getKey(keyAlias), ivParameterSpec)

        val payload = cipher.doFinal(bytes)
        val combined = ByteArray(iv.size + payload.size)

        System.arraycopy(iv, 0, combined, 0, iv.size)
        System.arraycopy(payload, 0, combined, iv.size, payload.size)

        return combined
    }

    @Throws(Exception::class)
    override fun decryptBytes(bytes: ByteArray): ByteArray {
        val iv = ByteArray(ivSize)
        System.arraycopy(bytes, 0, iv, 0, iv.size)
        val ivParameterSpec = IvParameterSpec(iv)

        val payloadSize = bytes.size - ivSize
        val payload = ByteArray(payloadSize)
        System.arraycopy(bytes, iv.size, payload, 0, payloadSize)

        cipher.init(Cipher.DECRYPT_MODE, aesKeyProvider.getKey(keyAlias), ivParameterSpec)

        return cipher.doFinal(payload)
    }

}
