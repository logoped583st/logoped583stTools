package com.logoped583st.android_tools.extensions

import android.graphics.Typeface
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan

fun Spannable.bold(vararg substrings: String): Spannable {
    applySpans(*substrings) { start, end ->
        setSpan(
                StyleSpan(Typeface.BOLD), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    return this
}

fun Spannable.strike(vararg substrings: String): Spannable {
    applySpans(*substrings) { start, end ->
        setSpan(StrikethroughSpan(), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    return this
}

fun Spannable.toColor(vararg substrings: String, color: Int): Spannable {
    applySpans(*substrings) { start, end ->
        setSpan(ForegroundColorSpan(color), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    return this
}


private inline fun Spannable.applySpans(
        vararg substrings: String,
        apply: (start: Int, end: Int) -> Unit
) {
    substrings.forEach {
        var index: Int = indexOf(it)
        while (index >= 0) {
            apply(index, index + it.length)
            index = indexOf(it, index + it.length)
        }
    }
}