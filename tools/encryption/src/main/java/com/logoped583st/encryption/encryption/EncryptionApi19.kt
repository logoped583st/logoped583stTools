package com.logoped583st.encryption.encryption

import java.security.Key
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

const val KEYSTORE_PROVIDER_ANDROID: String = "AndroidKeyStore"
const val KEY_ALIAS = "KEY_ALIAS"
const val TYPE_RSA = "RSA"
const val RSA_ENCRYPTION_ALGORITHM = "RSA/ECB/PKCS1Padding"

class EncryptionApi19(
        private val cipherRSA: Cipher,
        private val privateKey: PrivateKey,
        private val publicKey: PublicKey
) : ByteEncryption {

    init {
//        createRSAKeysIfNeeded(context)
    }

    @Throws(Exception::class)
    fun wrap(key: Key): ByteArray {
        cipherRSA.init(Cipher.WRAP_MODE, publicKey)

        return cipherRSA.wrap(key)
    }

    @Throws(Exception::class)
    fun unwrap(wrappedKey: ByteArray, algorithm: String): Key {
        cipherRSA.init(Cipher.UNWRAP_MODE, privateKey)

        return cipherRSA.unwrap(wrappedKey, algorithm, Cipher.SECRET_KEY)
    }

    @Throws(Exception::class)
    override fun encrypt(byteArray: ByteArray): ByteArray {
        cipherRSA.init(Cipher.ENCRYPT_MODE, publicKey)

        return cipherRSA.doFinal(byteArray)
    }

    @Throws(Exception::class)
    override fun decrypt(byteArray: ByteArray): ByteArray {
        cipherRSA.init(Cipher.DECRYPT_MODE, privateKey)

        return cipherRSA.doFinal(byteArray)
    }

}