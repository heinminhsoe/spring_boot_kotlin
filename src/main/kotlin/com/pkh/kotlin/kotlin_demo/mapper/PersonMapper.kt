package com.pkh.kotlin.kotlin_demo.mapper

import com.pkh.kotlin.kotlin_demo.dto.PersonDTO
import com.pkh.kotlin.kotlin_demo.entity.Person
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PersonMapper: EntityMapper<PersonDTO, Person> {
    @JvmDefault
    fun fromId(id: Long) = id?.let {
        val person = Person()
        person.id = id
        person
    }
}