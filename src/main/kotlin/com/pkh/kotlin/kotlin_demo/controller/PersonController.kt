package com.pkh.kotlin.kotlin_demo.controller

import com.pkh.kotlin.kotlin_demo.dto.PersonDTO
import com.pkh.kotlin.kotlin_demo.entity.Person
import com.pkh.kotlin.kotlin_demo.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/person")
class PersonController(
        private val personService: PersonService
){
    companion object {
        const val ENTITY_NAME = "Person"
    }

    @PostMapping
    fun createPerson(@Valid @RequestBody personDTO: PersonDTO): ResponseEntity<PersonDTO> {
        val result = personService.save(personDTO)
        return ResponseEntity.ok().body(result)
    }

    @PutMapping
    fun updatePerson(@Valid @RequestBody personDTO: PersonDTO): ResponseEntity<PersonDTO> {
        val result = personService.update(personDTO)
        return ResponseEntity.ok().body(result)
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        personService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllPersons(): ResponseEntity<MutableList<PersonDTO>> {
        return ResponseEntity.ok().body(personService.findAll())
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable("id") id: Long): ResponseEntity<PersonDTO> {
        return ResponseEntity.ok().body(personService.findOne(id).get())
    }
}