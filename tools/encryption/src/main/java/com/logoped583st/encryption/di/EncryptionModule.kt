package com.logoped583st.encryption.di

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.security.keystore.KeyProperties
import com.logoped583st.dagger_component_connector.di.Encryption
import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.encryption.encryption.EncryptionApi19
import com.logoped583st.encryption.encryption.EncryptionApi23
import com.logoped583st.encryption.encryption.provider.*
import dagger.Lazy
import dagger.Module
import dagger.Provides
import java.security.KeyPairGenerator
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.inject.Singleton


private const val RSA_ENCRYPTION_ALGORITHM = "RSA/ECB/PKCS1Padding"
private const val KEYSTORE_PROVIDER_ANDROID: String = "AndroidKeyStore"
private const val TYPE_RSA = "RSA"
private const val TYPE_AES = "AES"

@Module
internal class EncryptionModule {

    private val ks = KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID)

    init {
        ks.load(null, null)
    }

    @Provides
    @Singleton
    fun provideKeyStore(): KeyStore {
        return ks
    }

    @Provides
    @Singleton
    fun providerSpecGenerator(
            kpGenerator: Lazy<KeyPairGenerator>,
            context: Context,
            logger: Logger,
            keyGenerator: Lazy<KeyGenerator>
    ): KeySpecGenerator {
        return when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.M -> KeySpecProviderApiLZ23(context, logger, kpGenerator.get())
            else -> KeySpecProviderApiGZ23(logger, keyGenerator.get())
        }
    }


    @Provides
    @Singleton
    fun provideRsaKeyGenerator(): KeyPairGenerator? {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            KeyPairGenerator.getInstance(TYPE_RSA, KEYSTORE_PROVIDER_ANDROID)
        } else {
            null
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Provides
    @Singleton
    fun provideAESKeyGenerator(): KeyGenerator? {
        return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, KEYSTORE_PROVIDER_ANDROID)
        } else {
            null
        }
    }

    @Provides
    @Singleton
    fun provideCipher(): Cipher {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Cipher.getInstance(
                    RSA_ENCRYPTION_ALGORITHM,
                    "AndroidOpenSSL")
        } else {
            Cipher.getInstance("AES/CBC/PKCS7Padding",)
        }
    }

    @Singleton
    @Provides
    fun provideAESKeyProvider(keySpecGenerator: KeySpecGenerator): AESKeyProvider {
        return AESKeyProviderImpl(ks, keySpecGenerator)
    }


    @Singleton
    @Provides
    fun provideKeyProvider(ks: KeyStore, keySpecGenerator: KeySpecGenerator): RSAKeyProvider {
        return RSAKeyProviderImpl(ks, keySpecGenerator)
    }

    @Provides
    @Singleton
    fun provideByteEncryption(
            kp: RSAKeyProvider, cipher: Cipher, keyAlias: String, aesKeyProvider: AESKeyProvider
    ): Encryption {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            EncryptionApi19(cipher, kp, keyAlias)
        } else {
            EncryptionApi23(keyAlias, cipher, aesKeyProvider)
        }
    }

}