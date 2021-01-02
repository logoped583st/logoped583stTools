package com.logoped583st.logopedcomponents

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import com.logoped583st.dagger_component_connector.di.Encryption
import javax.inject.Inject


class MainActivity : Activity() {

    @Inject
    lateinit var encryption: Encryption

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}