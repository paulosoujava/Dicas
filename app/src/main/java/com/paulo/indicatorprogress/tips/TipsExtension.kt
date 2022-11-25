package com.paulo.indicatorprogress.tips

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate




@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    operator fun LocalDate.component1() = year
    operator fun LocalDate.component2() = month
    operator fun LocalDate.component3() = dayOfMonth

    val today = LocalDate.parse("2016-02-15")

    val (y,m,d) = today

    print("Year=$y day=$d, month=$m")
}