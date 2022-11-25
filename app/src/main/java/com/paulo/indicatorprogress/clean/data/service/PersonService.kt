package com.paulo.indicatorprogress.clean.data.service

import com.paulo.indicatorprogress.clean.data.dto.PersonDto
import com.paulo.indicatorprogress.clean.domain.model.Person

class PersonService {
    suspend fun getPersonDtos(): List<PersonDto> {
        return listOf(
            PersonDto(
                id = "1",
                name = "Michael",
                date_of_birth = "1994-10-22",
                address = "Example Address",
                country_code = "US"
            ),
            PersonDto(
                id = "2",
                name = "Marc",
                date_of_birth = "1991-01-22",
                address = "Example Address",
                country_code = "US"
            ),
            PersonDto(
                id = "3",
                name = "Larissa",
                date_of_birth = "1996-05-03",
                address = "Example Address",
                country_code = "US"
            )
        )
    }
    suspend fun insertNewPersons(personDtos: List<PersonDto>){
        //Insert persons..
    }
}