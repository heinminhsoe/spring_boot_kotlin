package com.pkh.kotlin.kotlin_demo.repository

import com.pkh.kotlin.kotlin_demo.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, String>