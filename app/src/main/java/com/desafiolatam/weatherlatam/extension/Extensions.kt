package com.desafiolatam.weatherlatam.extension

import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import java.util.Calendar
import java.util.Locale

fun Long.toShortDateString(): String {
    val calendar = Calendar.getInstance(Locale.getDefault())
    calendar.timeInMillis = this
    return "${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
}

fun Double.toFahrenheit(): Double {
    return this * 9 / 5 + 32
}

fun Double.toCelsius(): Double {
    return (this - 32) * 5 / 9
}

fun DialogFragment.setupWidthToMatchParent() {
    dialog?.window?.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
}