package com.logoped583st.android_tools.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

fun Context.pxToDp(px: Int) = (px.toDouble() / (resources.displayMetrics.density) / DisplayMetrics.DENSITY_DEFAULT).toInt()

fun Context.dpToPx(dp: Int) = (dp * resources.displayMetrics.density).toInt()

fun Context.getColorWrapper(id: Int) = ContextCompat.getColor(this, id)

@ColorInt
fun Context.resolveAttributeWithTheme(@AttrRes attribute: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attribute, typedValue, true)
    return typedValue.data
}

fun Context.makeClip(
        text: String,
        doOnSuccess: () -> Unit,
        doOnError: () -> Unit
) {
    getSystemService(Context.CLIPBOARD_SERVICE)?.let {
        val clipboard = it as ClipboardManager
        try {
            val clip =
                    ClipData.newPlainText(text, text)
            clipboard.setPrimaryClip(clip)
            doOnSuccess()
        } catch (e: NoSuchElementException) {
            doOnError()
        }
    }
}