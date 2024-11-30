package finance.home.presentation

import java.text.DecimalFormat
import java.text.NumberFormat

const val PATH = "home"

fun Number.formatToDollar(): String {
    val formatter: NumberFormat = DecimalFormat("#,###.##")
    return "$${formatter.format(this)}"
}