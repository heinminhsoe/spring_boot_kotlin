package com.pkh.kotlin.kotlin_demo.service.impl

import com.pkh.kotlin.kotlin_demo.dto.UserDTO
import com.pkh.kotlin.kotlin_demo.entity.User
import com.pkh.kotlin.kotlin_demo.mapper.UserMapper
import com.pkh.kotlin.kotlin_demo.repository.UserRepository
import com.pkh.kotlin.kotlin_demo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl  (
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val passwordEncoder: PasswordEncoder
): UserService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(userDTO: UserDTO?): UserDTO? {
        requireNotNull(userDTO)
        var user = userMapper.toEntity(userDTO)

        user?.passwordHash = passwordEncoder.encode(userDTO.password)

        user = userRepository.save(user)
        return userMapper.toDto(user)
    }

    override fun update(userDTO: UserDTO?): UserDTO? {
        requireNotNull(userDTO)

        var user:User  = userRepository.findById(userDTO.id).orElse(null) ?: return null;

        user.login = userDTO.login
        user.name = userDTO.name
        user.email = userDTO.email;
        user.langKey = userDTO.langKey
        user.roles = userMapper.rolesFromStrings(userDTO.roles)

        user = userRepository.save(user)
        return userMapper.toDto(user)
    }

    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }

    override fun findOne(id: Long): Optional<UserDTO> {
        return userRepository.findById(id).map(userMapper::toDto)
    }

    override fun findAll(): MutableList<UserDTO?> {
        return userRepository.findAll().mapTo(mutableListOf(), userMapper::toDto )
    }
}