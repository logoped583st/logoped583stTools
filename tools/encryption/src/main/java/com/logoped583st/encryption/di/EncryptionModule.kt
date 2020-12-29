package com.logoped583st.encryption.di

import android.os.Build
import com.logoped583st.encryption.encryption.RSA_ENCRYPTION_ALGORITHM
import dagger.Module
import dagger.Provides
import javax.crypto.Cipher
import javax.inject.Singleton

@Module
class EncryptionModule {

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