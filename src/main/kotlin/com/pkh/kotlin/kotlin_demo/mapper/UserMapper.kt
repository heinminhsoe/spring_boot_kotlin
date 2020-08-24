package com.pkh.kotlin.kotlin_demo.mapper

import com.pkh.kotlin.kotlin_demo.dto.UserDTO
import com.pkh.kotlin.kotlin_demo.entity.Role
import com.pkh.kotlin.kotlin_demo.entity.User
import org.springframework.stereotype.Service

@Service
class UserMapper {
    fun toDTO(user: User?): UserDTO? =
            when(user){
                null -> null
                else -> {
                    UserDTO(
                            id = user.id,
                            login = user.login,
                            name = user.name,
                            email = user.email,
                            langKey = user.langKey,
                            roles = stringsFromRoles(user.roles)
                    )
                }
            }
    fun toEntity(userDTO: UserDTO?): User? =
            when(userDTO) {
                null -> null
                else -> {
                    User(
                       id = userDTO.id,
                       login = userDTO.login,
                       name = userDTO.name,
                       email = userDTO.email,
                       langKey = userDTO.langKey,
                       roles = rolesFromStrings(userDTO.roles)
                    )
                }
            }

    fun toDTOs(users: MutableList<User?>): MutableList<UserDTO> =
            users.mapNotNullTo(mutableListOf()) { toDTO(it) }

    fun toEntities(userDTOs: MutableList<UserDTO?>): MutableList<User> =
            userDTOs.mapNotNullTo(mutableListOf()) { toEntity(it)}

    private fun rolesFromStrings(roles: MutableSet<String>?): MutableSet<Role> =
            roles?.mapTo(mutableSetOf()) { Role(it)} ?: mutableSetOf()

    private fun stringsFromRoles(roles: MutableSet<Role>?): MutableSet<String>? =
            roles?.mapTo(mutableListOf()) { it.name }?.filterNotNull()?.toMutableSet() ?: mutableSetOf()
}