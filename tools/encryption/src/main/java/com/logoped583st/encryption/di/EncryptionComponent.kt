package com.logoped583st.encryption.di

import android.content.Context
import com.logoped583st.dagger_component_connector.di.EncryptionProvider
import com.logoped583st.dagger_component_connector.di.Logger
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [EncryptionModule::class])
internal interface EncryptionComponent: EncryptionProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun keyAlias(keyAlias: String): Builder

        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun logger(logger: Logger): Builder

        fun build(): EncryptionComponent
    }
}

fun initEncryption(keyAlias: String, context: Context, logger: Logger): EncryptionProvider {
    return DaggerEncryptionComponent.builder()
            .context(context)
            .logger(logger)
            .keyAlias(keyAlias)
            .build()
}