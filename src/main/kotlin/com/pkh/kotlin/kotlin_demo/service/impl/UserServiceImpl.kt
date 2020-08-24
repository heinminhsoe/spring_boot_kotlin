package com.pkh.kotlin.kotlin_demo.service.impl

import com.pkh.kotlin.kotlin_demo.dto.UserDTO
import com.pkh.kotlin.kotlin_demo.mapper.UserMapper
import com.pkh.kotlin.kotlin_demo.repository.UserRepository
import com.pkh.kotlin.kotlin_demo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl  (
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(userDTO: UserDTO): UserDTO? {
        var user = userMapper.toEntity(userDTO)
        user = userRepository.save(user)
        return userMapper.toDto(user)
    }

    override fun update(userDTO: UserDTO): UserDTO? {
        var user = userMapper.toEntity(userDTO)
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