package com.pkh.kotlin.kotlin_demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.GenerationType


@Entity
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "address", nullable = false)
    var address: String? = null
){
    override fun toString() = "Person {" +
       "id: $id" +
       ", name: $name" +
       ", address: $address" +
       "}"
}