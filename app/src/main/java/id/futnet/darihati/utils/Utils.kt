package id.futnet.darihati.utils

import android.view.View
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*


fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun dateFormat(oldDate: String) : String {
    val tempDate = SimpleDateFormat("yyyy-MM-dd").parse(oldDate)

//    locale and data format symbols
    val locale = Locale("en", "UK")
    val dateFormatSymbols = DateFormatSymbols(locale)
    dateFormatSymbols.shortWeekdays=arrayOf("Unused", "Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab")
    dateFormatSymbols.shortMonths=arrayOf( "Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul","Agu","Sep","Okt","Nov","Des")

    val pattern = "EEE, dd MMM yyyy"
//    formating date
    val simpleDateFormat = SimpleDateFormat(pattern, locale)
    simpleDateFormat.dateFormatSymbols=dateFormatSymbols

    val date = simpleDateFormat.format(tempDate)

    return date
}

fun toGMTFormat(date: String?, time: String?): String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date $time"
    val temp= formatter.parse(dateTime)
    return SimpleDateFormat("HH:mm").format(temp)
}

fun TimeInMillis(date: String?, time: String?): Long {
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date $time"
    val date:Date=formatter.parse(dateTime)
    return date.time
}