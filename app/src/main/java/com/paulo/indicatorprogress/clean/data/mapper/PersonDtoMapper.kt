package com.paulo.indicatorprogress.clean.data.mapper



import com.paulo.indicatorprogress.clean.data.dto.PersonDto
import com.paulo.indicatorprogress.clean.domain.model.Person
import java.text.SimpleDateFormat
import java.util.*

fun PersonDto.toPerson():Person{

    val inputSDF = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = inputSDF.parse(date_of_birth)
    val milliseconds: Long = date?.time ?: 0

    return Person(
        id = id,
        name = name,
        dateOfBirthInMs = milliseconds
    )

}

fun Person.toPersonDto():PersonDto{
    val inputSDF = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = Date(dateOfBirthInMs)

    return PersonDto(
        id = id,
        name = name,
        date_of_birth = inputSDF.format(date)
    )
}