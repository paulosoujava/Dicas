package com.paulo.indicatorprogress.clean.presentation.mapper

import androidx.compose.ui.graphics.Color
import com.paulo.indicatorprogress.clean.domain.model.Person

import com.paulo.indicatorprogress.clean.presentation.state.PersonUIItem
import java.text.SimpleDateFormat
import java.util.*

fun Person.toPersonUIItem():PersonUIItem{

    val inputSDF = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
    val date = Date(dateOfBirthInMs)

    val color = if (name.count()>5) Color.Red else Color.Green

    return PersonUIItem(
        id = id,
        name = name,
        dateOfBirth = inputSDF.format(date),
        color = color
    )

}

fun PersonUIItem.toPerson():Person{

    val inputSDF = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = inputSDF.parse(dateOfBirth)
    val milliseconds: Long = date?.time ?: 0

    return Person(
        id = id,
        name = name,
        dateOfBirthInMs = milliseconds
    )
}