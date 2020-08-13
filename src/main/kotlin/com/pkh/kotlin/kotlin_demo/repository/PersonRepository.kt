package com.pkh.kotlin.kotlin_demo.repository

import com.pkh.kotlin.kotlin_demo.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>