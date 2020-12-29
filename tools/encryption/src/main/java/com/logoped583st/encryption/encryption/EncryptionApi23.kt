package com.logoped583st.encryption.encryption

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Base64
import com.logoped583st.dagger_component_connector.di.Logger
import java.security.Key
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

const val KEY_ALGORITHM = "AES"
const val AES_ENCRYPTION_ALGORITHM = "AES/CBC/PKCS7Padding"
const val AES_PREFERENCES_KEY = "mgen_preferences_key"

@SuppressLint("CheckResult")
@TargetApi(Build.VERSION_CODES.M)
class EncryptionApi23(
        private val rsaCipher: EncryptionApi19,
        private val context: Context,
        private val preferences: SharedPreferences,
        private val logger: Logger
) : ByteEncryption {

    private val ivSize = 16
    private val keySize = 16

    private var secretKey: Key? = null
    private val cipher: Cipher by lazy { Cipher.getInstance(AES_ENCRYPTION_ALGORITHM) }
    private lateinit var secureRandom: SecureRandom

    init {
        storageCipher18Implementation()
    }

    @Throws(Exception::class)
    fun storageCipher18Implementation() {
        secureRandom = SecureRandom()

        val editor = preferences.edit()

        val aesKey = preferences.getString(AES_PREFERENCES_KEY, null)

        val encrypted: ByteArray
        try {
            encrypted = Base64.decode(aesKey, Base64.DEFAULT)
            secretKey = rsaCipher.unwrap(encrypted, KEY_ALGORITHM)
            return
        } catch (e: Exception) {
//            Logger.e(Logger.LOG_TAG, "unwrap key failed  $e")
        }

        val key = ByteArray(keySize)
        secureRandom.nextBytes(key)
        secretKey = SecretKeySpec(key, KEY_ALGORITHM)

        try {
            secretKey?.let { secretKey ->
                val encryptedKey = rsaCipher.wrap(secretKey)
                editor.putString(AES_PREFERENCES_KEY,
                        Base64.encodeToString(encryptedKey, Base64.DEFAULT))
                editor.apply()
            }
        } catch (e: Exception) {
//            Logger.exceptionLog("wrap key failed  ${e.message}", e)
        }
    }

    @Throws(Exception::class)
    override fun encrypt(byteArray: ByteArray): ByteArray {
        val iv = ByteArray(ivSize)
        secureRandom.nextBytes(iv)

        val ivParameterSpec = IvParameterSpec(iv)

        // TODO() Refactor this class to remove workarounds
        if (secretKey == null) {
            storageCipher18Implementation()
        }

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec)

        val payload = cipher.doFinal(byteArray)
        val combined = ByteArray(iv.size + payload.size)

        System.arraycopy(iv, 0, combined, 0, iv.size)
        System.arraycopy(payload, 0, combined, iv.size, payload.size)

        return combined
    }

    @Throws(Exception::class)
    override fun decrypt(byteArray: ByteArray): ByteArray {
        val iv = ByteArray(ivSize)
        System.arraycopy(byteArray, 0, iv, 0, iv.size)
        val ivParameterSpec = IvParameterSpec(iv)

        val payloadSize = byteArray.size - ivSize
        val payload = ByteArray(payloadSize)
        System.arraycopy(byteArray, iv.size, payload, 0, payloadSize)

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec)

        return cipher.doFinal(payload)
    }

}
