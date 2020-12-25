package com.logoped583st.network_core.converters

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

private const val timeZone = "GMT"

internal class DateConverter @Inject constructor(): JsonDeserializer<Date> {

    private val possibleDateFormats = arrayOf(
        "yyyy-MM-dd'T'HH:mm:ssZ",
        "yyyy-MM-dd'T'HH:mm:ss",
        "yyyy-MM-dd",
        "EEE MMM dd HH:mm:ss z yyyy",
        "HH:mm:ss",
        "MM/dd/yyyy HH:mm:ss aaa",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'",
        "MMM d',' yyyy H:mm:ss a"
    )

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date {
        possibleDateFormats.forEach {
            try {
                val formatter = SimpleDateFormat(it, Locale.getDefault())
                formatter.timeZone = TimeZone.getTimeZone(timeZone)

                return formatter.parse(json?.asString)
            } catch (exception: ParseException) {
            }
        }

        throw JsonParseException("Can't deserialize date ${json?.asString}")
    }
}