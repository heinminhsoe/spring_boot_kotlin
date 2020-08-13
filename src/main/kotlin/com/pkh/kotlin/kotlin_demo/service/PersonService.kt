package com.pkh.kotlin.kotlin_demo.service

import com.pkh.kotlin.kotlin_demo.dto.PersonDTO
import java.util.*

interface PersonService {
    fun save(personDTO: PersonDTO): PersonDTO

    fun update(personDTO: PersonDTO): PersonDTO

    fun delete(id: Long)

    fun findOne(id: Long): Optional<PersonDTO>

    fun findAll(): MutableList<PersonDTO>
}