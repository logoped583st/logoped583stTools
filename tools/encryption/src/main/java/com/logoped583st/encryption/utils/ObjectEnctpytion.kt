package com.logoped583st.encryption.utils

import com.google.gson.Gson
import com.logoped583st.dagger_component_connector.di.Encryption


inline fun <reified T> Encryption.encryptObject(obj: T, gson: Gson): String {
    return encryptString(gson.toJson(obj, obj!!::class.java))
}

inline fun <reified T> Encryption.decryptObj(encryptedObj: String, gson: Gson): T {
    return gson.fromJson(decryptString(encryptedObj), T::class.java)
}
