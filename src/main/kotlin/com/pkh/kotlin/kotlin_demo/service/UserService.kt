package com.pkh.kotlin.kotlin_demo.service

import com.pkh.kotlin.kotlin_demo.dto.UserDTO
import java.util.*

interface UserService {
    fun save(userDTO: UserDTO?): UserDTO?

    fun update(userDTO: UserDTO?): UserDTO?

    fun delete(id: Long)

    fun findOne(id: Long): Optional<UserDTO>

    fun findAll(): MutableList<UserDTO?>

}