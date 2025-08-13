package com.example.clazzi.util

import android.R.attr.data
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatDate(date: Date?) : String{
    if(date == null) return ""
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA)
    sdf.timeZone = TimeZone.getTimeZone("Asia/Seoul")
    return sdf.format(date)
}