package com.paulo.indicatorprogress.clean.data.repository


import com.paulo.indicatorprogress.clean.data.mapper.toPerson
import com.paulo.indicatorprogress.clean.data.mapper.toPersonDto
import com.paulo.indicatorprogress.clean.data.service.PersonService
import com.paulo.indicatorprogress.clean.domain.FilterPersonsUseCase
import com.paulo.indicatorprogress.clean.domain.model.Person

class PersonRepository(
    private val personService: PersonService = PersonService(),
    private val filterPersonsUseCase: FilterPersonsUseCase
) {
    suspend fun getPersons(): List<Person> {
        return filterPersonsUseCase(
            personService.getPersonDtos().map {
                it.toPerson()
            }
        )
    }

    suspend fun insertPersons(personList: List<Person>) {
        personService.insertNewPersons(personList.map { it.toPersonDto() })
    }
}