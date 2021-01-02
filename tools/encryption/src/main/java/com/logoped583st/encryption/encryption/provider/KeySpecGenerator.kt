package com.logoped583st.encryption.encryption.provider

import java.util.*

internal abstract class KeySpecGenerator {

    protected fun keyLifeTime(): Pair<Calendar, Calendar> {
        val start = Calendar.getInstance()
        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 5)

        return Pair(start, end)
    }

    abstract fun setupSpec(alias: String)
}
