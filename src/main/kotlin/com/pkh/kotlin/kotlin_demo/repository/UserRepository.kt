package com.pkh.kotlin.kotlin_demo.repository

import com.pkh.kotlin.kotlin_demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}