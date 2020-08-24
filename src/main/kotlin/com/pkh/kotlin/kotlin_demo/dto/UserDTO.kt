package com.pkh.kotlin.kotlin_demo.dto

import com.pkh.kotlin.kotlin_demo.entity.Role
import org.hibernate.annotations.BatchSize
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UserDTO(
        var id: Long? = null,

        @field:NotBlank
        @field:Size(min = 1, max = 50)
        var login: String? = null,

        @field:Size(max = 20)
        var password: String? = null,

        @field:NotBlank
        @field:Size(min = 1, max = 100)
        var name: String? = null,

        @field:Size(min = 1, max = 100)
        var email: String? = null,

        @field:Size(min = 1, max = 10)
        var langKey: String? = null,

        @field:NotNull
        var roles: MutableSet<String>? = null
) {
        override fun toString(): String  = "UserDTO {" +
                "login : $login ," +
                "name : $name ," +
                "email : $email , " +
                "langKey: $langKey ," +
                "authorities: $roles " +
                "}"
}