package com.pkh.kotlin.kotlin_demo.service.impl

import com.pkh.kotlin.kotlin_demo.dto.PersonDTO
import com.pkh.kotlin.kotlin_demo.mapper.PersonMapper
import com.pkh.kotlin.kotlin_demo.repository.PersonRepository
import com.pkh.kotlin.kotlin_demo.service.PersonService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository,
    private val personMapper: PersonMapper
): PersonService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(personDTO: PersonDTO): PersonDTO {
        var person = personMapper.toEntity(personDTO)
        person = personRepository.save(person)
        return personMapper.toDto(person)
    }

    override fun update(personDTO: PersonDTO): PersonDTO {
        var person = personMapper.toEntity(personDTO)
        person = personRepository.save(person)
        return personMapper.toDto(person)
    }

    override fun delete(id: Long) {
        personRepository.deleteById(id)
    }

    override fun findOne(id: Long): Optional<PersonDTO> {
        return personRepository.findById(id).map(personMapper::toDto)
    }

    override fun findAll(): MutableList<PersonDTO> {
       return personRepository.findAll().mapTo(mutableListOf(), personMapper::toDto)
    }

}