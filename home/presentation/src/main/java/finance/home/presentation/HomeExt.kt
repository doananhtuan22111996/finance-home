package finance.home.presentation

import java.text.DecimalFormat
import java.text.NumberFormat

fun Number.formatToDollar(): String {
    val formatter: NumberFormat = DecimalFormat("#,###.##")
    return "$${formatter.format(this)}"
}