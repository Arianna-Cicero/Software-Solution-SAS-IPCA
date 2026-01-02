package com.example.lojasocial_app.core.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    private val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    fun format(date: Date): String = sdf.format(date)

    fun parse(value: String): Date? = try {
        sdf.parse(value)
    } catch (e: Exception) {
        null
    }
}

