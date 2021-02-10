package com.logoped583st.encryption.utils

import android.util.Base64
import com.logoped583st.dagger_component_connector.di.Encryption
import java.nio.charset.Charset


fun Encryption.encryptString(input: String): String {
    return Base64.encodeToString(
            encryptBytes(input.toByteArray()),
            Base64.NO_WRAP)
}

fun Encryption.decryptString(input: String): String {
    return Base64.decode(input, Base64.NO_WRAP).let {
        decryptBytes(it).toString(Charset.defaultCharset())
    }
}