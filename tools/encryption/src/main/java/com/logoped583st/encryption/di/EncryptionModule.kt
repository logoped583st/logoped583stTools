package com.logoped583st.encryption.di

import android.content.Context
import android.os.Build
import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.encryption.encryption.KEYSTORE_PROVIDER_ANDROID
import com.logoped583st.encryption.encryption.RSA_ENCRYPTION_ALGORITHM
import com.logoped583st.encryption.encryption.key_generator.RSAKeyProvider
import com.logoped583st.encryption.encryption.key_generator.RSAProviderApiGZ28
import com.logoped583st.encryption.encryption.key_generator.RSAProviderApiLZ23
import com.logoped583st.encryption.encryption.key_generator.RSAProviderApiLZ28
import dagger.Module
import dagger.Provides
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.inject.Singleton

@Module
class EncryptionModule {

    @Provides
    @Singleton
    fun provideKeyStore(): KeyStore {
        return KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID)
    }

    @Provides
    @Singleton
    fun provideRsaKeyGenerator(context: Context, logger: Logger, ks: KeyStore): RSAKeyProvider {
        return when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.M -> RSAProviderApiLZ23(context, logger, ks)
            Build.VERSION.SDK_INT < Build.VERSION_CODES.P -> RSAProviderApiLZ28(logger, ks)
            else -> RSAProviderApiGZ28(ks)
        }
    }

    @Provides
    @Singleton
    fun provideRsaCipher(): Cipher {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Cipher.getInstance(RSA_ENCRYPTION_ALGORITHM, "AndroidOpenSSL")
        } else {
            Cipher.getInstance(RSA_ENCRYPTION_ALGORITHM, "AndroidKeyStoreBCWorkaround")
        }
    }
}