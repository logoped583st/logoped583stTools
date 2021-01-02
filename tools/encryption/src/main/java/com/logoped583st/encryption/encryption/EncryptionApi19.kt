package com.logoped583st.encryption.encryption

import com.logoped583st.dagger_component_connector.di.Encryption
import com.logoped583st.encryption.encryption.provider.RSAKeyProvider
import javax.crypto.Cipher

internal class EncryptionApi19(
        private val cipherRSA: Cipher,
        private val rsaKeyProvider: RSAKeyProvider,
        private val keyAlias: String
) : Encryption {

    override fun encryptBytes(bytes: ByteArray): ByteArray {
        cipherRSA.init(Cipher.ENCRYPT_MODE, rsaKeyProvider.getPublicKey(keyAlias))

        return cipherRSA.doFinal(bytes)
    }

    override fun decryptBytes(bytes: ByteArray): ByteArray {
        cipherRSA.init(Cipher.DECRYPT_MODE, rsaKeyProvider.getPrivateKey(keyAlias))

        return cipherRSA.doFinal(bytes)
    }

}