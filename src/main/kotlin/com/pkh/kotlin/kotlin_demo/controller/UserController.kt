package com.pkh.kotlin.kotlin_demo.controller

import com.pkh.kotlin.kotlin_demo.dto.UserDTO
import com.pkh.kotlin.kotlin_demo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
class UserController (
    private val userService: UserService
){
    @PostMapping
    fun createUser(@Valid @RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        val result = userService.save(userDTO)
        return ResponseEntity.ok().body(result)
    }

    @PutMapping
    fun updateUser(@Valid @RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        val result = userService.update(userDTO)
        return ResponseEntity.ok().body(result)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        userService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<MutableList<UserDTO?>> {
        return ResponseEntity.ok().body(userService.findAll())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Long): ResponseEntity<UserDTO> {
        return ResponseEntity.ok().body(userService.findOne(id).get())
    }
}