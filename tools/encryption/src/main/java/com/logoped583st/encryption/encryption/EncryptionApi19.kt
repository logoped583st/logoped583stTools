package com.logoped583st.encryption.encryption

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.security.KeyPairGeneratorSpec
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.StrongBoxUnavailableException
import java.math.BigInteger
import java.security.*
import java.util.*
import javax.crypto.Cipher
import javax.security.auth.x500.X500Principal

const val KEYSTORE_PROVIDER_ANDROID: String = "AndroidKeyStore"
const val KEY_ALIAS = "KEY_ALIAS"
const val TYPE_RSA = "RSA"
const val RSA_ENCRYPTION_ALGORITHM = "RSA/ECB/PKCS1Padding"

class EncryptionApi19(
        val context: Context,
        private val cipherRSA: Cipher
) : ByteEncryption {

    private val ks = KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID)

    init {
        ks.load(null, null)
        createRSAKeysIfNeeded(context)
    }

    @Throws(Exception::class)
    fun wrap(key: Key): ByteArray {
        val publicKey = getPublicKey()
        cipherRSA.init(Cipher.WRAP_MODE, publicKey)

        return cipherRSA.wrap(key)
    }

    @Throws(Exception::class)
    fun unwrap(wrappedKey: ByteArray, algorithm: String): Key {
        val privateKey = getPrivateKey()
        cipherRSA.init(Cipher.UNWRAP_MODE, privateKey)

        return cipherRSA.unwrap(wrappedKey, algorithm, Cipher.SECRET_KEY)
    }

    @Throws(Exception::class)
    override fun encrypt(byteArray: ByteArray): ByteArray {
        val publicKey = getPublicKey()
        cipherRSA.init(Cipher.ENCRYPT_MODE, publicKey)

        return cipherRSA.doFinal(byteArray)
    }

    @Throws(Exception::class)
    override fun decrypt(byteArray: ByteArray): ByteArray {
        val privateKey = getPrivateKey()
        cipherRSA.init(Cipher.DECRYPT_MODE, privateKey)

        return cipherRSA.doFinal(byteArray)
    }

    @Throws(Exception::class)
    private fun getPrivateKey(): PrivateKey {
        return (ks.getKey(KEY_ALIAS, null)
                ?: throw Exception("No key found under alias: $KEY_ALIAS")) as? PrivateKey
                ?: throw Exception("Not an instance of a PrivateKey")
    }

    @Throws(Exception::class)
    private fun getPublicKey(): PublicKey {
        val cert = ks.getCertificate(KEY_ALIAS)
                ?: throw Exception("No certificate found under alias: $KEY_ALIAS")

        return cert.publicKey ?: throw Exception("No key found under alias: $KEY_ALIAS")
    }


    @SuppressLint("NewApi")
    @Throws(Exception::class)
    private fun createRSAKeysIfNeeded(context: Context) {
        val privateKey = ks.getKey(KEY_ALIAS, null)
        if (privateKey == null) {
            when {
                Build.VERSION.SDK_INT < Build.VERSION_CODES.M -> createKeys(context)
                Build.VERSION.SDK_INT < Build.VERSION_CODES.P -> createKeysAndroidM()
                else -> createKeysAndroidP()
            }
        }
    }

    @Throws(Exception::class)
    private fun createKeys(context: Context) {
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
//            Logger.e(Logger.LOG_TAG, e.message, e)
        }
    }

    @Throws(Exception::class)
    @TargetApi(Build.VERSION_CODES.M)
    private fun createKeysAndroidM() {
        val start = Calendar.getInstance()
        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 25)

        val kpGenerator = KeyPairGenerator.getInstance(TYPE_RSA, KEYSTORE_PROVIDER_ANDROID)

        val spec = KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
                .setCertificateSubject(X500Principal("CN=$KEY_ALIAS"))
                .setDigests(KeyProperties.DIGEST_SHA256)
                .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                .setCertificateSerialNumber(BigInteger.valueOf(1))
                .setCertificateNotBefore(start.time)
                .setCertificateNotAfter(end.time)
                .build()

        try {
            kpGenerator.initialize(spec)
            kpGenerator.generateKeyPair()
        } catch (e: Exception) {
//            Logger.e(Logger.LOG_TAG, e.message, e)
        }
    }

    @Throws(Exception::class)
    @TargetApi(Build.VERSION_CODES.P)
    private fun createKeysAndroidP() {
        val start = Calendar.getInstance()
        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 25)

        val kpGenerator = KeyPairGenerator.getInstance(TYPE_RSA, KEYSTORE_PROVIDER_ANDROID)

        val spec = KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
                .setCertificateSubject(X500Principal("CN=$KEY_ALIAS"))
                .setDigests(KeyProperties.DIGEST_SHA256)
                .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                .setCertificateSerialNumber(BigInteger.valueOf(1))
                .setCertificateNotBefore(start.time)
                .setCertificateNotAfter(end.time)
                .setIsStrongBoxBacked(true)
                .build()

        try {
            kpGenerator.initialize(spec)
            kpGenerator.generateKeyPair()
        } catch (se: StrongBoxUnavailableException) {
            val localSpec = KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
                    .setCertificateSubject(X500Principal("CN=$KEY_ALIAS"))
                    .setDigests(KeyProperties.DIGEST_SHA256)
                    .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                    .setCertificateSerialNumber(BigInteger.valueOf(1))
                    .setCertificateNotBefore(start.time)
                    .setCertificateNotAfter(end.time)
                    .build()
            kpGenerator.initialize(localSpec)
            kpGenerator.generateKeyPair()
        }

    }
}