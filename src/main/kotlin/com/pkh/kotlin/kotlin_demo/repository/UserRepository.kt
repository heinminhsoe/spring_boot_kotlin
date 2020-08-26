package com.pkh.kotlin.kotlin_demo.repository

import com.pkh.kotlin.kotlin_demo.entity.User
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long> {
    @EntityGraph(attributePaths = ["authorities"])
    @Cacheable(cacheNames = [USERS_BY_LOGIN_CACHE])
    fun findOneWithAuthoritiesByLogin(login: String): Optional<User>

    @EntityGraph(attributePaths = ["authorities"])
    @Cacheable(cacheNames = [USERS_BY_EMAIL_CACHE])
    fun findOneWithAuthoritiesByEmailIgnoreCase(email: String): Optional<User>

    companion object {

        const val USERS_BY_LOGIN_CACHE: String = "usersByLogin"

        const val USERS_BY_EMAIL_CACHE: String = "usersByEmail"
    }
}