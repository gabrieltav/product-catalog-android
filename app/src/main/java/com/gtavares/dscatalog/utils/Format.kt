package com.gtavares.dscatalog.utils

import java.text.NumberFormat
import java.util.Locale

fun Double.formatToBrazilianReal(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formatter.format(this)
}